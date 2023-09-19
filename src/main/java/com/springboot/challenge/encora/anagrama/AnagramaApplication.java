package com.springboot.challenge.encora.anagrama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
public class AnagramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnagramaApplication.class, args);
	}

}
@RestController
class AnagramController {

	@GetMapping("/checkAnagram")
	public boolean checkAnagram(
			@RequestParam("first-word") String firstWord,
			@RequestParam("second-word") String secondWord
	) {
		return isAnagram(firstWord, secondWord);
	}

	public static boolean isAnagram(String first, String second) {
		String firstWord = first.replaceAll("\\s", "").toLowerCase();
		String secondWord = second.replaceAll("\\s", "").toLowerCase();

		if (firstWord.length() != secondWord.length()) {
			return false;
		}

		char[] listfirstWord = firstWord.toCharArray();
		char[] listsecondWord = secondWord.toCharArray();

		Arrays.sort(listfirstWord);
		Arrays.sort(listsecondWord);

		return Arrays.equals(listfirstWord, listsecondWord);
	}
}
