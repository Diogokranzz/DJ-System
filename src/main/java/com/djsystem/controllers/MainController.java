package com.djsystem.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.djsystem.models.Track;
import com.djsystem.audio.DeckPlayer;

public class MainController {
    @FXML private TableView<Track> libraryTable;
    @FXML private TableColumn<Track, String> titleColumn;
    @FXML private TableColumn<Track, String> artistColumn;
    @FXML private TableColumn<Track, String> durationColumn;
    @FXML private TableColumn<Track, Integer> bpmColumn;
    
    @FXML private TableView<Track> playlistTable;
    @FXML private TableColumn<Track, Integer> orderColumn;
    @FXML private TableColumn<Track, String> playlistTitleColumn;
    @FXML private TableColumn<Track, String> playlistDurationColumn;
    
    @FXML private Slider volumeA;
    @FXML private Slider volumeB;
    @FXML private Slider speedA;
    @FXML private Slider speedB;
    @FXML private Slider crossFader;
    @FXML private Text statusText;
    
    private DeckPlayer deckA;
    private DeckPlayer deckB;
    private ObservableList<Track> library;
    private ObservableList<Track> playlist;
    
    @FXML
    public void initialize() {
        initializeTables();
        initializeSliders();
        initializePlayers();
        loadDefaultTracks();
    }
    
    private void initializeTables() {
        // Configure library table
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        bpmColumn.setCellValueFactory(new PropertyValueFactory<>("bpm"));
        
        // Configure playlist table
        orderColumn.setCellValueFactory(new PropertyValueFactory<>("order"));
        playlistTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        playlistDurationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        
        library = FXCollections.observableArrayList();
        playlist = FXCollections.observableArrayList();
        
        libraryTable.setItems(library);
        playlistTable.setItems(playlist);
    }
    
    private void initializeSliders() {
        volumeA.setValue(100);
        volumeB.setValue(100);
        speedA.setValue(100);
        speedB.setValue(100);
        crossFader.setValue(50);
        
        volumeA.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (deckA != null) deckA.setVolume(newVal.doubleValue() / 100.0);
        });
        
        volumeB.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (deckB != null) deckB.setVolume(newVal.doubleValue() / 100.0);
        });
        
        speedA.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (deckA != null) deckA.setSpeed(newVal.doubleValue() / 100.0);
        });
        
        speedB.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (deckB != null) deckB.setSpeed(newVal.doubleValue() / 100.0);
        });
        
        crossFader.valueProperty().addListener((obs, oldVal, newVal) -> {
            updateCrossFader(newVal.doubleValue());
        });
    }
    
    private void initializePlayers() {
        deckA = new DeckPlayer();
        deckB = new DeckPlayer();
        
        libraryTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Track selectedTrack = libraryTable.getSelectionModel().getSelectedItem();
                if (selectedTrack != null) {
                    if (!deckA.isPlaying()) {
                        deckA.loadTrack(selectedTrack.getFilePath());
                        deckA.play();
                    } else if (!deckB.isPlaying()) {
                        deckB.loadTrack(selectedTrack.getFilePath());
                        deckB.play();
                    }
                }
            }
        });
    }
    
    private void loadDefaultTracks() {
        handleImportMusic();
    }
    
    private void updateCrossFader(double value) {
        double deckAVolume = (100 - value) / 100.0;
        double deckBVolume = value / 100.0;
        
        if (deckA != null) deckA.setVolume(deckAVolume * (volumeA.getValue() / 100.0));
        if (deckB != null) deckB.setVolume(deckBVolume * (volumeB.getValue() / 100.0));
    }
    
    @FXML
    private void handleImportMusic() {
        Track track1 = new Track("LET'S GO", "Unknown Artist", "3:00", 128, "mp3/LET'S GO.mp3");
        
        Track track2 = new Track("CHAPA MAXIMA", "MC Rick, Boladin 211 e MC Leozinho ZS", "3:30", 130, 
            "mp3/MC Rick, Boladin 211 e MC Leozinho ZS - CHAPA MAXIMA ( DJ LV MDP E CAOS NO BEAT ).mp3");
        
        library.addAll(track1, track2);
        statusText.setText("Music imported successfully");
    }
    
    @FXML
    private void handleExportPlaylist() {
        // TODO: Implement playlist export functionality
        statusText.setText("Exporting playlist...");
    }
    
    @FXML
    private void handleExit() {
        // Cleanup and exit
        if (deckA != null) deckA.stop();
        if (deckB != null) deckB.stop();
        System.exit(0);
    }
}