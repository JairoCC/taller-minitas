package com.keycode.TallerMinitas;
import com.keycode.TallerMinitas.models.ApplicationUser;
import com.keycode.TallerMinitas.models.DeminingType;
import com.keycode.TallerMinitas.models.Role;
import com.keycode.TallerMinitas.repository.DeminingTypeRepository;
import com.keycode.TallerMinitas.repository.RoleRepository;
import com.keycode.TallerMinitas.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TallerMinitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerMinitasApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, DeminingTypeRepository deminingTypeRepository){
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1,"admin", passwordEncoder.encode("password"), "Bogota", roles);
			userRepository.save(admin);

			DeminingType typeHumanitarian = new DeminingType(1,"Bogota","Humanitario","Jairo");
			deminingTypeRepository.save(typeHumanitarian);
			DeminingType typeMilitar = new DeminingType(2,"Medellin","Militar","Jairo");
			deminingTypeRepository.save(typeMilitar);

		};
	}

}
