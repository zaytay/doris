package cn.xdf.doris.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainConfig implements FileChangeListener {

    private static class SingletonHolder {
        private static MainConfig instance = new MainConfig();
    }

    public static Logger log = LoggerFactory.getLogger(MainConfig.class);

    public static MainConfig getInstance() {
        return SingletonHolder.instance;
    }

    private String filePath = DynamicConfig.getString("main_config.dir");

    private MainConfig() {
        updateConfig();
        FileMonitor.getInstance().addFileChangeListener(this, filePath, 10000);
    }

    @Override
    public void fileChanged(String filename) {
        updateConfig();
    }

    public void updateConfig() {

    }

}
