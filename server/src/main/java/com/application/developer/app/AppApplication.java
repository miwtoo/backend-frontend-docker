package com.application.developer.app;

import com.application.developer.app.entity.Item;
import com.application.developer.app.repository.ItemRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
    ApplicationRunner init(ItemRepository repository) {
        return args -> {
			repository.save(new Item("IU", "https://t1.daumcdn.net/cfile/tistory/2417974F5446359B0D?original"));
			repository.save(new Item("Lisa", "https://instagram.fbkk5-3.fna.fbcdn.net/vp/a81140a3d0ab48314be80c053aabe292/5D2FE03F/t51.2885-15/e35/17439124_253714398367608_7832646602614374400_n.jpg?_nc_ht=instagram.fbkk5-3.fna.fbcdn.net"));
			repository.save(new Item("Rosie", "https://i0.wp.com/blackpinkupdate.com/wp-content/uploads/2018/10/9-BLACKPINK-Rose-Tokyo-Girls-Collection-Kitakyushu-2018-Photos.jpg?fit=682%2C1024&ssl=1"));
			repository.save(new Item("Jennie", "https://pbs.twimg.com/media/DsV0fIuVsAARd2Z.jpg:orig"));
			repository.save(new Item("Jisoo", "https://i.pinimg.com/originals/79/8e/cc/798ecc26aec9dd57778ee034173d58e0.jpg"));
            repository.findAll().forEach(System.out::println);
        };
    }
}
