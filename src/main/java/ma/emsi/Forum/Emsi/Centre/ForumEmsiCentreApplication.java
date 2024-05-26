package ma.emsi.Forum.Emsi.Centre;

import ma.emsi.Forum.Emsi.Centre.services.UserAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ForumEmsiCentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumEmsiCentreApplication.class, args);
	}
	//@Bean
	CommandLineRunner commandLineRunnerUserDetails(UserAccountService userAccountService){
		return args -> {
			userAccountService.addNewRole("Student");
			userAccountService.addNewRole("Teacher");
			userAccountService.addNewRole("SectorManager");
			userAccountService.addNewRole("Admin");
			userAccountService.addNewStudent("Sabir","Yassine","Yassine49","SABIR_YASSINE@emsi-edu.ma","1234","0657757022","IIR","4ème année",6);
			userAccountService.addNewTeacher("Ettaki","Hasnaa","Hasnaa16","ETTAKI_HASNAA@emsi-edu.ma","12343","0636988030","IIR");
			userAccountService.addNewSectorManager("Assia","Essafi","AssiaSafi","ESSAFI_ASSIA@emsi-edu.ma","1234","0605313273","IIR","4ème année");
			userAccountService.addNewAdmin("AkilAya","AKIL_AYA@emsi-edu.ma","4321","0687684613");
			userAccountService.addRoleToUser("Yassine49","Student");
			userAccountService.addRoleToUser("Hasnaa16","Teacher");
			userAccountService.addRoleToUser("AssiaSafi","SectorManager");
			userAccountService.addRoleToUser("AkilAya","Admin");
			userAccountService.addRoleToUser("AkilAya","Student");
			userAccountService.addRoleToUser("AkilAya","Teacher");
		};
	}
}
