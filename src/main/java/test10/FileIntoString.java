package test10;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIntoString {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("D:\\新建文本文档.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
	}
}
