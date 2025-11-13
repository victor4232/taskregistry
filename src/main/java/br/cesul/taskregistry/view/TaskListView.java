package br.cesul.taskregistry.view;

import br.cesul.taskregistry.model.Task;
import br.cesul.taskregistry.viewmodel.TaskListViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TaskListView {

    @FXML
    private TextField tituloField;

    @FXML
    private TextField descField;

    @FXML
    private Button btnAdd;

    @FXML
    private TableView<Task> tableView;

    @FXML
    private TableColumn<Task, String> colTitulo;

    @FXML
    private TableColumn<Task, String> colDesc;

    private TaskListViewModel viewModel;

    public void setViewModel(TaskListViewModel vm) {
        this.viewModel = vm;
        tableView.setItems(vm.getItems());
    }

    @FXML
    private void initialize() {
        // configurar colunas via nomes dos getters
        colTitulo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("title"));
        colDesc.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("description"));

        // configurar botão adicionar
        btnAdd.setOnAction(ev -> {
            try {
                String title = tituloField.getText();
                String desc = descField.getText();
                viewModel.addTask(title, desc);
                // limpar campos
                tituloField.clear();
                descField.clear();
                // selecionar novo item (último)
                if (!viewModel.getItems().isEmpty()) {
                    tableView.getSelectionModel().selectLast();
                }
            } catch (IllegalArgumentException ex) {
                // mostrar erro simples
                Alert alert = new Alert(Alert.AlertType.WARNING, ex.getMessage(), ButtonType.OK);
                alert.showAndWait();
            } catch (Throwable ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao adicionar tarefa", ButtonType.OK);
                alert.showAndWait();
            }
        });


        // desabilitar botão se título em branco
        btnAdd.disableProperty().bind(Bindings.createBooleanBinding(
                () -> tituloField.getText() == null || tituloField.getText().trim().isEmpty(),
                tituloField.textProperty()
        ));
    }
}
