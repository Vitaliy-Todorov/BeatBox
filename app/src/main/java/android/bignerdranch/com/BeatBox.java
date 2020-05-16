package android.bignerdranch.com;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

public class BeatBox {

    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;
    /*Для обращения к активам используется класс AssetManager. Экземпляр этого класса можно получить
    для любой разновидности Context. Так как BeatBox понадобится такой экземпляр, предоставьте ему
    конструктор, который получает Context, извлекает AssetManager и сохраняет на будущее.*/

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try{
            soundNames = mAssets.list(SOUNDS_FOLDER);                                           //list(String) - получить список доступных активов. AssetManager.list(String) возвращает список имен файлов, содержащихся в заданной папке.
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException ioe) {
            Log.i(TAG, "Could not list assets", ioe);
            return;
        }
    }
}
