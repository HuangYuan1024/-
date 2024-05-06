package org.CurriculumDesign.SupermarketCashierSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SupermarketCashierSystemApplication extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        RunDataBase();
        Application.launch(args);
        StopRunDataBase();
    }

    public static void RunDataBase() {
        try {
            // 获取当前工作目录
            String workingDir = System.getProperty("user.dir");

            // 构建批处理文件路径
            String batFilePath = workingDir + File.separator + "MySQL5.5.6" + File.separator + "mysql5.5.6" + File.separator + "mysql_start.bat";

            // 创建ProcessBuilder对象
            ProcessBuilder processBuilder = new ProcessBuilder(batFilePath);

            // 设置工作目录
            processBuilder.directory(new File(workingDir + File.separator + "MySQL5.5.6" + File.separator + "mysql5.5.6"));

            // 启动进程
            Process process = processBuilder.start();

            // 等待进程执行完成
            int exitCode = process.waitFor();

            // 检查退出码
            if (exitCode == 0) {
                System.out.println("MySQL开启成功！");
            } else {
                System.out.println("MySQL开启失败！");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void StopRunDataBase() {
        try {
            // 获取当前工作目录
            String workingDir = System.getProperty("user.dir");

            // 构建批处理文件路径
            String batFilePath = workingDir + File.separator + "MySQL5.5.6" + File.separator + "mysql5.5.6" + File.separator + "mysql_stop.bat";

            // 创建ProcessBuilder对象
            ProcessBuilder processBuilder = new ProcessBuilder(batFilePath);

            // 设置工作目录
            processBuilder.directory(new File(workingDir + File.separator +  "MySQL5.5.6" + File.separator + "mysql5.5.6"));

            // 启动进程
            Process process = processBuilder.start();

            // 等待进程执行完成
            int exitCode = process.waitFor();

            // 检查退出码
            if (exitCode == 0) {
                System.out.println("MySQL关闭成功！");
            } else {
                System.out.println("MySQL关闭失败！");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SupermarketCashierSystemApplication.stage = primaryStage;
        changeView( "fxml/login.fxml");
        primaryStage.setTitle("超市收银系统");
        String workingDir = System.getProperty("user.dir");
        primaryStage.getIcons().add(new Image(workingDir + File.separator + "image" + File.separator + "cookie.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void changeView(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(SupermarketCashierSystemApplication.class.getResource(fxml));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(SupermarketCashierSystemApplication.class.getResource("css/main.css")).toExternalForm());
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}