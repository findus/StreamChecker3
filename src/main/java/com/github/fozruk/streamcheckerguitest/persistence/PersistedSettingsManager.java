package com.github.fozruk.streamcheckerguitest.persistence;

import com.github.fozruk.streamcheckerguitest.exception.PropertyKeyNotFoundException;

import java.io.*;
import java.util.Properties;

/**
 * Created by Philipp on 14.06.2015.
 * Settings file Keys that you need:
 *
 * livestreamer=
 * videoPlayer=
 * token_twitch=
 * username=
 *
 */
public class PersistedSettingsManager extends PersistenceManager {

    Properties settings = new Properties();
    private static PersistedSettingsManager manager;


    private PersistedSettingsManager() throws IOException {
        loadSettings();
    }

    public static PersistedSettingsManager getInstance() throws IOException {
        if(manager == null)
            manager = new PersistedSettingsManager();
        return manager;
    }

    private void loadSettings() throws IOException {
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(SETTINGS_FILE));
        settings.load(stream);
        stream.close();
    }



    public File getLivestremer() throws PropertyKeyNotFoundException {
        String property = settings.getProperty("livestreamer");
        File livestreamer = null;
        if (property != null) {
            livestreamer = new File(property);
        } else {
            throw new PropertyKeyNotFoundException();
        }
        return livestreamer;
    }

    public File getVideoPlayer() throws PropertyKeyNotFoundException {
        String property = settings.getProperty("videoPlayer");
        File livestreamer = null;
        if (property != null) {
            livestreamer = new File(property);
        } else {
            throw new PropertyKeyNotFoundException();
        }
        return livestreamer;
    }

    public String getValue(String value)
    {
        String property = settings.getProperty(value);
        return property;
    }
}
