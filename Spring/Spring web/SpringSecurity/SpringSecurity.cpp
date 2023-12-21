tasks {
	+ воспроизвести ошибку ещё раз, чтобы посмотреть текст ошибок
	+ в собранном варианте воспроизвести ошибку
	
	+ разнести разрешения в конфигурации SecurityFilterChain {
	Этим самым нужно убедиться, что приоритетным будет правило, 
	которое описано выше. Плюс есть условие, что anyRequest 
	должен быть последним правилом (как минимум после requestMatchers),
	так как он устанавливает правило "по дефолту" {
			
			Пример 1 (right)
			...
			.(/some/shit).authenticated()
			.(/some/**).permitAll()
			.anyRequest.authenticated()
			...
			
			Пример 2 (wrong)
			...
			.(/some/**).permitAll()
			.(/some/shit).authenticated()
			.anyRequest.authenticated()
			...
			
			Пример 3 (right)
			...
			.(/some/shit).permitAll()
			.(/some/**).authenticated()
			.anyRequest.authenticated()
			...
			
			Пример 4 (wrong)
			...
			.(/some/**).authenticated()
			.(/some/shit).permitAll()
			.anyRequest.authenticated()
			...
			
			Пример 3 и 4 то же самое, но поменять permit  и authenticated
			
			Ожидания были неоднозначные, так как в любом случае была логика:
			с одной стороны, могал работать логика перезаписи,
			и частные правила в этом случае стоит писать позже,
			с другой стороны могла работать логика последовательного 
			сопоставления url к правилу. Это значило бы, что частные правила 
			нужно писать в начале.
			
			Результат: в действительности работает принцип последовательного
			сопоставления, то есть частные правила стоит писать в начале.
			Это также согласуется с anyRequest, как дефолтным вариантом.
		}
	
	}
	
	+ попробовать другие вараинты доступа (после requestMatchar): denyAll, anonymous
	
	+ поменять urls, проверить
	+ вернуть обратно и добавить ещё один бин, 
	+ определять Bean через профили, а профили через application.yaml
	
	+ поэкспериментировать с порядком конфигурации, кажется, что глобального порядка не должно быть
	+ сделать её нелогичной: дать разрешения не все url всем roles.
	+ сделать dufault настройки, как если бы 
	я не добавлял SecurityFilterChain Bean
	
	
	+ Ошибка. Я сделал 2 юзера: withDefaultPasswordEncoder
	и с BCryptPasswordEncoder
		+ ещё раз проверить в чём разница и почему возникает ошибка
			DelegetingPasswordEncoder записывает id перед хешированным паролем
			BCrypt этого не делает
			+ продебажить для надёжости, проверить как выглядят пароли в InMemoryUserDetailsManager
			
	
	+ addFilter... Как добавлять фильтры со своей логикой?
		+ усправление ошибки social-media
		Статус ответа мнеяется в ExceptionTranslationFilter.class
	
	+ Как обрабатывать исключения, например истечение токена?
	
	- UserDetails: своя реализация с возможными вариантами:
		+ defaultPasswordEncoder
		- без кодиравания
		- какую-нибудь свою реализацию


	- попробовать сделать 2 разных filter chain {
		Когда я создал несколько бинов SecurityFilterChain ошибки не было. Возможно всё потому что они инжектятся как лист в список цепей. То есть, это возможно и есть способ создать несколько отдельных chain.
		Вопрос только в том, как указать первый matcher
		Возмоно это делается методом securityMatcher();
	}
	- поэкспериментировать с ordering filter chain {
		- попробовать поменять местами мою реализацию и дефолтную
	}

}



Вид конфигурации SecurityFilterChain не представляет собой фильтр.
Фильтры уже существуют - конфигурация их конфигурирует:
	Что-то отключает, что-то подключает, что-то меняет.


Есть несколько вариантов записи:
	
	// Размазанный
	.authorizeHttpRequests()
	.requestMatchers("/","/home").permitAll()
	.anyRequest().authenticated()
	.and()
	// и далее другие методы
	
	//Собранный
	.authorizeHttpRequests((requests) -> requests
		.requestMatchers("/", "/home").permitAll()
		.anyRequest().authenticated())
	// и далее другие методы
	
	Результат одинаковый.
	В случае собранного уточнения описываются внутри
	В случае размазанного уточнения описываются после, 
	и заканчиваются специальным методом and(), 
	чтобы перейти к следующим методам


Глобально порядок методов роли не играет, но может играть локально в некоторых ситуациях.

	В каких случая не играет роли
		
		// Этот код
        http
                .authorizeHttpRequests()
                    .requestMatchers("/","/home").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();

		// Работает также как этот. 
        http
                .logout((logout) -> logout.permitAll()) // эту строчку подняли
				.authorizeHttpRequests()
                    .requestMatchers("/","/home").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin((form) -> form.loginPage("/login").permitAll());
        return http.build();
		
		
	В каких случаях играет роль
		// Это работать будет
		http
                .authorizeHttpRequests()
                    .requestMatchers("/","/home").permitAll() // (1)
                    .anyRequest().authenticated()			  // (2)
                    .and()
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
		
		тут эти два элемента как-будто говорят:
			.requestMatchers("/","/home").permitAll() // в / и /home ходить разрешаем
			.anyRequest().authenticated() 			  // а в остальные места запрещаем (нужно аутентифицироваться)
		
		// Работать не будет
		http
                .authorizeHttpRequests()
                    .anyRequest().authenticated() // эту строчку подняли.
                    .requestMatchers("/","/home").permitAll()
                    .and()
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();

		Здесь получается какое-топротиворечие:
			.anyRequest().authenticated() 				// в остальные места запрещаем
			.requestMatchers("/","/home").permitAll()   // в / и /home ходить разрешаем (а как, если уже в остальные места ходить запретили?)
		
		В общем логика такая: от частного к общему.
		Сначала описываем что-то частное, что будет иметь больший приоритет.
		далее описывается общее
		Для точного понимания: сервис просто по очереди сравниваниет матчеры, 
		и сработает на первом подошёдшем