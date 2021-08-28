//package learning.main;
//
//import java.io.IOException;
//import cn.papercheck.algorithm.PaperManager;
//import cn.papercheck.algorithm.check.ClauseCheck;
//import cn.papercheck.algorithm.check.ContinuityCheck;
//import cn.papercheck.algorithm.pojo.Paper;
//import cn.papercheck.algorithm.pojo.PaperLibrary;
//import cn.papercheck.algorithm.pojo.PaperLibraryCore;
//import cn.papercheck.algorithm.report.DefaultReporter;
//import cn.papercheck.algorithm.report.DefaultTemplate;
//import cn.papercheck.authentication.Auth;
//
//import java.io.File;
//import java.io.IOException;
//
//
///**
// * Created by qincasin on 2020/5/2.
// */
//public class Main2 {
//
//    /**
//     * SDK进阶使用范例
//     */
//
//    public static void main(String[] args) throws IOException {
//        //获取机器码
//        System.out.println(Auth.getMachineCode());
//        //A3FD915C348D6FC5494DD65361A35EBD
//        //设置注册码（免费获取：https://dreamspark.com.cn/blog/?id=7）
//        //HE8O2Vfef8UL6PPWLbbaswe5xLcOK2I+ekspWILR/tf26yW5OO+MGvmQlmmwU/FbtjR5lC1FBq9Kr3UZLpweb49XPz818RPm7sCNeQVuKigvFaHCC8fWUNeelEKAOHnvIOgWXsY1HPzKI77hD2nA34Fqe1NVPmEs0yyLYzwWtzW2nEczc0SRCfY9nNdL2aZNW1xY2m1gfhyDH0X5NckINEOAkAzbAw8axKWAF75puNOeJp0RDUUgj1phHG/rgQXJ6UzhBxdpbhSKY5YRtS/FJ+Yyq4C6+Bn2NgjoqF1hRzY919/KnzIfE0kyWhVJvA1synAc/6vn63eTF3xU0qOwKboJ0nGJBzcvM+QfTESVQQ6LieJ7Bs/oDsQXEQFag0jkRdPfEnB04IFfjsA7GRKibC1dFHBdxACrKkDIzchtEmsug9UOGPuQYtFacg7Y+cz4jP7k0JeeYaG1s8k5czQMYzotFSKs2W67qeDVwmrzYtE=
//        PaperManager.INSTANCE.setRegCode("HE8O2Vfef8UL6PPWLbbaswe5xLcOK2I+ekspWILR/tf26yW5OO+MGvmQlmmwU/FbtjR5lC1FBq9Kr3UZLpweb49XPz818RPm7sCNeQVuKigvFaHCC8fWUNeelEKAOHnvIOgWXsY1HPzKI77hD2nA34Fqe1NVPmEs0yyLYzwWtzW2nEczc0SRCfY9nNdL2aZNW1xY2m1gfhyDH0X5NckINEOAkAzbAw8axKWAF75puNOeJp0RDUUgj1phHG/rgQXJ6UzhBxdpbhSKY5YRtS/FJ+Yyq4C6+Bn2NgjoqF1hRzY919/KnzIfE0kyWhVJvA1synAc/6vn63eTF3xU0qOwKboJ0nGJBzcvM+QfTESVQQ6LieJ7Bs/oDsQXEQFag0jkRdPfEnB04IFfjsA7GRKibC1dFHBdxACrKkDIzchtEmsug9UOGPuQYtFacg7Y+cz4jP7k0JeeYaG1s8k5czQMYzotFSKs2W67qeDVwmrzYtE=");
//        //检查注册状态
//        System.out.println(PaperManager.INSTANCE.regState());
////
////        //加载、构建比对库
////        PaperLibraryCore paperLibrary = new PaperLibrary("/Users/qinjiaxing/Desktop/paper/"); //比对库所在文件夹（Paper序列化文件）
////        paperLibrary.build(); //构建比对库
//
//        //读取转换待查重的文件
////        Paper toCheckPaper = new Paper(new File("C:\\Users\\admin\\Desktop\\test.docx"));
//        Paper toCheckPaper = new Paper(new File("/Users/qinjiaxing/Desktop/paper/test.docx"));
//
//        //构建并启动任务
//        PaperManager.INSTANCE
//                .getCheckTaskBuilder() //获取查重任务构造器
//                .setUid("1") //设置任务id
//                .setCheckState(new CheckStateImp()) //设置回调处理
////                .setLibrary(paperLibrary) //设置比对库
//                .setToCheckPaper(toCheckPaper) //设置待查Paper
//                .setReporter(new DefaultReporter()) //设置自定义的查重报告构造器。如不设置，默认即为DefaultReporter
//                .setTemplate(new DefaultTemplate()) //设置查重报告样式模板。如不设置，默认即为DefaultTemplate
//                .addCheckCore(new ClauseCheck(0.85f)) //添加查重算法。如不添加则会自动添加ClauseCheck(0.8)
//                .build() //构建任务
//                .submit(); //启动任务。submit：将任务提交到线程池中，如果线程池繁忙将会排队。start：直接启动任务
//    }
//}
