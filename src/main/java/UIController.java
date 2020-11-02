import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class UIController {


    private String selected;
    @FXML
    private TextField wordSearch;
    @FXML
    private Button listenButton;
    @FXML
    private TextFlow textFlow;
    @FXML
    private ListView<String> wordListView;


    public void initialize() throws IOException {
        DictionaryManagement.insertFromFile();
        ObservableList<String> wordObservableList = FXCollections.observableArrayList(Dictionary.words.keySet());
        wordListView.setItems(wordObservableList);
        wordListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Your action here
            selected = newValue.toString();
            showDefinition(selected);
            wordSearch.setText(selected);
        });
    }

    @FXML
    private void buttonClicked() {
        showDefinition(wordSearch.getText());
    }

    @FXML
    private void showDefinition(String text) {
        selected = text.toLowerCase();
        textFlow.getChildren().clear();
        String s = DictionaryManagement.dictionaryLookup(text);
        Text t = new Text(s);
        listenButton.setDisable(s.equals("Không tìm thấy"));
        textFlow.getChildren().add(t);
    }

    public void listenButtonClicked() throws MalformedURLException {
        StringBuilder audioURL = new StringBuilder("https://dictionary.cambridge.org/vi/media/english/us_pron/");
        String s = selected.toLowerCase();
        StringBuilder sbs = new StringBuilder(s);
        while (sbs.length() < 5) {
            sbs.append("_");
        }
        s = sbs.toString();
        audioURL.append(s.charAt(0)).append("/").append(s.substring(0, 3)).append("/")
                .append(s.substring(0, 5)).append("/").append(selected.toLowerCase()).append(".mp3");
        System.out.println(audioURL);
        final URL resource = new URL(audioURL.toString());
        final Media media = new Media(resource.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }


}
