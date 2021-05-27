package com.example.demo;


import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class OperacaoTask extends AsyncTask<Integer, Integer, Void> {

    private TextView text;

    public OperacaoTask(TextView text) {
        this.text = text;
    }

    //É onde acontece o processamento. Este método é executado em uma thread a parte,
    //ou seja ele não pode atualizar a interface gráfica, por isso ele chama o método onProgressUpdate,
    // o qual é executado pela UI thread.
    @Override protected Void doInBackground(Integer... params) {
        int n = params[0];
        int i = 0; while(i < n){
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            //Notifica o Android de que ele precisa fazer atualizações na
            //tela e chama o método onProgressUpdate para fazer a atualização da interface gráfica
            //passando o valor do //contador como parâmetro.
            publishProgress(i);
            i++;
        }
        return null;
    }

    // É invocado para fazer uma atualização na interface gráfica
    @Override protected void onProgressUpdate(Integer... values) {
        text.setText(String.valueOf(values[0]));
    }

}