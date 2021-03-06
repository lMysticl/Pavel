
package CalcFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalcFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Calculator");
		primaryStage.setScene((Scene) createScene());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	TextField var1 = new TextField("������ ������ ��������");
	TextField znak = new TextField("�������� ��������");
	TextField var2 = new TextField("�������� ������ ��������");
	TextField res = new TextField("��� ���������");
	private static Integer first = 0;
	private static Integer second = 0;
	private static Integer result = 0;
	private static String znak2;

	private Object createScene() {
		Label label1 = new Label("��� ������������ ����� �������� ����������� TAB");
		label1.setLayoutX(5);
		label1.setLayoutY(14);
		HBox args = new HBox(10);
		HBox sumbut = new HBox(50);
		HBox boxresult = new HBox(10);
		VBox mainBox = new VBox();
		mainBox.getChildren().add(label1);
		mainBox.getChildren().add(args);
		mainBox.getChildren().add(sumbut);
		mainBox.getChildren().add(boxresult);
		boxresult.getChildren().add(res);
		// pervaya stroka

		args.getChildren().add(var1);
		args.getChildren().add(znak);
		args.getChildren().add(var2);
		sumbut.setAlignment(Pos.CENTER);
		res.setAlignment(Pos.TOP_CENTER);
		// vtoraya stroka

		Button btn1 = new Button("=");
		sumbut.getChildren().add(btn1);
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					first = Integer.parseInt(var1.getText());
					znak2 = znak.getText();
					second = Integer.parseInt(var2.getText());

					if (znak2.equals("+")) {
						result = first + second;
						res.setText(result.toString());
					} else if (znak2.equals("-")) {
						result = first - second;
						res.setText(result.toString());
					} else if (znak2.equals("*")) {
						result = first * second;
						res.setText(result.toString());
					} else if (znak2.equals("/")) {
						result = first / second;
						res.setText(result.toString());
					} else {
						res.setText("��, ��� ���� �� ������...");
					}

				} catch (Exception e) {
					System.out.println("�����");
				}

			}
		});

		// tretyaya stroka

		Scene scene = new Scene(mainBox, 500, 300);
		return scene;
	}

}