package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.model.Racobeu;
import com.example.demo.repo.RacobeuRepository;

@SpringBootApplication
public class RacobeuApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacobeuApplication.class, args);
	}
	
	@Bean //sī funkcija stratēsies automātiski, pēc programmas palaišanas
	public CommandLineRunner testModelLayer(RacobeuRepository racobeuRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Racobeu r1 = new Racobeu("Racobeu", "Projekts: “RACOBEU: Radioastronomija. Sadarbība starp Eiropas universitātēm:\n"
						+ "Zinātnisko un tehnoloģisko prasmju attīstīšana, izmantojot astronomiju”, projekta Nr.\n"
						+ "2023-1-ES01-KA220-HED-000155868 (RACOBEU), tiek īstenots ar programmas\n"
						+ "ERASMUS+ atbalstu (KA220 Sadarbības partnerība augstākajā izglītībā). Projekta\n"
						+ "īstenošanas periods: 11.01.2023-31.10.2026.\n"
						+ "Projekts ir vērsts uz jauna izglītības modeļa definēšanu, kurā tiek integrētas\n"
						+ "zināšanas astronomijā un radioastronomijā.\n"
						+ "Projektā sadarbojas trīs universitātes, kur AMU Observatorija specializējas\n"
						+ "optiskajā astronomijā, VeA Ventspils starptautiskais radioastronomijas centrs (VSRC)\n"
						+ "specializējas radioastronomijā, savukārt UPNA specializējas antenās un trīs vidusskolas.\n"
						+ "Projekta ietvaros, sadarbībā ar augstskolām caur inovatīvām mācību metodēm un praktisku\n"
						+ "darbošanos, skolotāji un skolēni apgūs astronomijas un radioastronomijas prasmes ar mērķi\n"
						+ "nākotnē izveidot skolās izvēles mācību priekšmetus astronomijā un radioastronomijā,\n"
						+ "veicinot skolēnu interesi par STEM karjeru.\n"
						+ "Projekta rezultātā tiks izstrādātas astronomijas kursu augstskolām vadlīnijas,\n"
						+ "izveidoti mācību materiāli astronomijas un radioastronomijas mācību priekšmetiem skolās,\n"
						+ "īstenotas izglītojošas aktivitātes izpratnes par STEM karjeru veicināšanai, kā arī kopienas\n"
						+ "izveide, kur veikt kopīgus novērojumus un īstenot skolēnu, studentu, skolotāju un\n"
						+ "pasniedzēju apmaiņas programmas.\n"
						+ "Projekta finansējums 250000 eiro, tostarp 57352 eiro VeA budžets.", 66090301);
				
				racobeuRepository.save(r1);
				
				
			
				
			}
		};
	}
}
