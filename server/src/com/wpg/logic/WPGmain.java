//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class WPGmain {
//
//    public static void main(String[] args) {
//
//        if(args.length == 0){
//            QuizDriver quiz = new QuizDriver();
//            quiz.run();
//        } else {
//            readScoreTextFile(args[0]);
//        }
//
//    }
//
//    private static void readScoreTextFile(String path){
//        try {
//            File file = new File(path);
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] splitList = line.split(", ");
//
//            }
//            fileReader.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
