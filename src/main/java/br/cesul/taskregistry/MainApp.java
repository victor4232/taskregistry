package br.cesul.taskregistry;

import br.cesul.taskregistry.repository.TaskRepository;
import br.cesul.taskregistry.repository.TaskRepositoryFake;
import br.cesul.taskregistry.view.TaskListView;
import br.cesul.taskregistry.viewmodel.TaskListViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // criar repo fake e viewmodel
        TaskRepository repository = new TaskRepositoryFake();
        TaskListViewModel vm = new TaskListViewModel(repository);
        // popular com exemplos (opcional)
        repository.save(new br.cesul.taskregistry.model.Task("Comprar leite", "2 litros"));
        repository.save(new br.cesul.taskregistry.model.Task("Estudar", "MVVM e Test Doubles"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/cesul/taskregistry/TaskView.fxml"));
        Scene scene = new Scene(loader.load());
        TaskListView controller = loader.getController();
        controller.setViewModel(vm);

        // carregar dados iniciais
        vm.loadAll();

        stage.setScene(scene);
        stage.setTitle("Cadastro de Tarefas - MVVM (Fake Repo)");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
