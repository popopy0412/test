import java.io.*;
import java.util.*;

public class FileAppend {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        FileReader fr = null;
        FileWriter fw = null;

        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야합니다.");
        System.out.print("첫 번째 파일 이름을 입력하세요>>");
        String file1 = scan.nextLine();
        System.out.print("두 번째 파일 이름을 입력하세요>>");
        String file2 = scan.nextLine();
        System.out.print("합치는 파일 이름을 입력하세요>>");
        String file3 = scan.nextLine();

        int c;
        try{
            fr = new FileReader(file1);
            fw = new FileWriter(file3, true);
            while((c = fr.read()) != -1){
                fw.write((char)c);
            }
            fw.write("\n");
            fr = new FileReader(file2);
            while((c = fr.read()) != -1){
                fw.write((char)c);
            }
            fr.close();
            fw.close();
            System.out.println("프로젝트 폴더 밑에 c.txt 파일에 저장하였습니다.");
        } catch (FileNotFoundException e) { // 파일을 찾지 못하였을 때 발생하는 예외 처리
            e.printStackTrace();
        } catch (IOException e) { // 입출력에 오류가 생겼을 때 발생하는 예외 처리
            e.printStackTrace();
        }
    }
}
