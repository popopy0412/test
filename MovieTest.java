import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class MovieTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<String, Movie> movie = new HashMap<String, Movie>(); // 영화 정보를 담은 HashMap 생성
        FileOutputStream fo = null;
        FileInputStream fi = null;
        ObjectOutputStream oo = null;
        ObjectInputStream oi = null;
        Scanner scan = new Scanner(System.in);

        while(true) {
            String title, director, genre; // 제목, 감독, 장르
            int year; // 년도를 입력받는 변수
            int menu; // 메뉴를 입력받는 변수
            System.out.println("============영화 정보 관리============");
            System.out.print("1.입력/2.출력/3.검색/4.수정/5.삭제/6.종료/7.파일 저장/8.파일 열기\n메뉴입력>>");
            menu = scan.nextInt(); // 메뉴 입력
            scan.nextLine();
            switch(menu) {
                case 1: // 입력
                    System.out.print("제목: ");
                    title = scan.nextLine();
                    System.out.print("감독: ");
                    director = scan.nextLine();
                    System.out.print("장르: ");
                    genre = scan.nextLine();
                    System.out.print("년도: ");
                    year = scan.nextInt();

                    Movie m = new Movie(title, director, genre, year); // Movie 객체 생성
                    movie.put(title, m);
                    break;
                case 2: // 출력
                    Set<String> s = movie.keySet();
                    Iterator<String> it = s.iterator();
                    while(it.hasNext()) {
                        System.out.println(movie.get(it.next()));

                    }
                    break;
                case 3: // 검색
                    System.out.print("검색할 제목 입력: ");
                    title = scan.nextLine();
                    if(movie.containsKey(title)){ // 검색할 영화가 있으면
                        System.out.print("검색 결과 " + movie.get(title));
                    }
                    else { // 없으면
                        System.out.println("영화가 없습니다.");
                    }
                    System.out.println();
                    break;
                case 4: // 수정
                    System.out.print("수정할 제목 입력: ");
                    title = scan.nextLine();
                    if(movie.containsKey(title)){ // 검색한 영화 출력
                        System.out.println(movie.get(title));
                    }
                    if(movie.containsKey(title)) { // 수정할 영화가 있으면
                        String new_title;
                        System.out.print("제목: ");
                        new_title = scan.nextLine();
                        System.out.print("감독: ");
                        director = scan.nextLine();
                        System.out.print("장르: ");
                        genre = scan.nextLine();
                        System.out.print("년도: ");
                        year = scan.nextInt(); // 수정할 정보를 입력 받고

                        Movie new_movie = new Movie(new_title, director, genre, year);
                        movie.remove(title);
                        movie.put(new_title, new_movie); // 새로운 정보로 대체
                        System.out.println(new_movie+"로 수정되었습니다.");
                    }
                    else { // 수정할 영화가 없으면
                        System.out.println("수정할 영화의 정보가 없습니다."); // 없다고 출력
                    }
                    break;

                case 5: // 삭제
                    System.out.print("삭제할 제목 입력: ");
                    title = scan.nextLine();
                    if(movie.containsKey(title)) { // 삭제할 영화가 있으면
                        System.out.println(movie.get(title)+"이 삭제되었습니다.");
                        movie.remove(title); // 영화 삭제
                    }
                    else { // 삭제할 영화의 정보가 없으면
                        System.out.print("삭제할 영화의 정보가 없습니다."); // 없다고 출력
                    }
                    break;

                case 6: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;

                case 7: // 파일 저장
                    fo = new FileOutputStream("movie.dat"); // 먼저 FileOutputStream으로 파일을 불러옴
                    oo = new ObjectOutputStream(fo); // 그 후 ObjectOutputStream으로 파일을 불러옴

                    oo.writeObject(movie); // HashMap 객체인 movie를 저장
                    System.out.println("movie.dat 파일에 저장합니다.");

                    oo.close();
                    fo.close();
                    break;
                case 8: // 파일 열기
                    fi = new FileInputStream("movie.dat"); // 먼저 FileInputStream으로 파일을 불러옴
                    oi = new ObjectInputStream(fi); // 그 후 ObjectInputStream으로 파일을 불러옴

                    if(movie.size() > 0) { // 만약 현재 movie 객체에 들어있는 정보가 있다면
                        while(true) { // yes혹은 no를 입력했을 때만 종료되는 반복문
                            System.out.print("파일로부터 데이터를 불러오면서 메모리에 기존 데이터가 삭제될 수 있습니다.\n계속하시겠습니까?(yes or no)"); // 경고 메세지를 띄우고
                            String temp = scan.nextLine();
                            if(temp.equals(("yes"))){ // yes를 입력하면
                                movie = (HashMap<String, Movie>) oi.readObject();
                                System.out.println("데이터를 성공적으로 가져왔습니다."); // 데이터를 불러오고
                                break; // 반복문 종료
                            }
                            else if (temp.equals("no")) break; // no를 입력하면 그냥 반복문 종료
                            else{ // 다른 답을 입력하면 다시 입력
                                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                            }
                        }
                    }
                    else { // movie 객체에 들어있는 정보가 없다면
                        movie = (HashMap<String, Movie>) oi.readObject();
                        System.out.println("데이터를 성공적으로 가져왔습니다."); // 그냥 movie.dat에 있는 정보를 가져옴
                    }

                    oi.close();
                    fi.close();
            }
            if(menu == 6) break; // 종료

        }
    }



}
