package cnhh.lvtn.bangtuanhoan.Activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import cnhh.lvtn.bangtuanhoan.R;

public class DienKhuyetActivity extends AppCompatActivity {

    private TextView mTvQuestion;
    List<Posi> posis = new ArrayList<>();

    private static final Character START_CODE = '&';
    private static final Character END_CODE = '|';
    private static final Character START_SHOW = '{';
    private static final Character END_SHOW = '}';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_khuyet);

        mTvQuestion = findViewById(R.id.tv_question);

        SpannableString spannableString = handleClickQuestion("300 là số có &| chữ số, chia &| cho 2 và là số &|.");

        mTvQuestion.setText(spannableString);
        mTvQuestion.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void check(View view) {
        Log.i("hihihi", mTvQuestion.getText().toString());
        String text = mTvQuestion.getText().toString();

        String dapAn = "{3}, {het}, {chan}";
        String strDapAn[] = dapAn.split(", ");

        String temp = "";
        int index = 0;

        for (int i = 0; i < posis.size() ; i++) {
            Posi posi = posis.get(i);
            temp += text.substring(index, posi.start);
            //Log.i("hihihi", text.substring(posi.start, posi.end));
            if(text.substring(posi.start, posi.end).equals(strDapAn[i])){
                //Log.i("hihihi", "xong r");
                temp += "<font color='green'>" + text.substring(posi.start, posi.end) + "</font>";
            }else{
                temp += "<font color='red'>" + text.substring(posi.start, posi.end) + "</font>";
            }
            index = posi.end;
        }
        if (index < text.length()){
             temp += text.substring(index, text.length());

        }
        //Log.i("hihihi",temp);
        mTvQuestion.setText(Html.fromHtml(temp));
    }

    private class Posi {
        int start;
        int end;

        Posi(int s, int e) {
            start = s;
            end = e;
        }
    }

    private SpannableString handleClickQuestion(String question) {
        ClickableSpan span;

        Log.i("ANTN", question);
        question = question.replace(START_SHOW, START_CODE);
        question = question.replace(END_SHOW, END_CODE);

        posis.clear();
        for (int i = 0; i < question.length() - 1; i++) {
            if (question.substring(i, i + 1).equals("&")) {
                for (int j = i + 1; j < question.length() - 1; j++) {
                    if (question.substring(j, j + 1).equals("|")) {
                        posis.add(new Posi(i, j + 1));
                        break;
                    }
                }
            }
        }

        question = question.replace(START_CODE, START_SHOW);
        question = question.replace(END_CODE, END_SHOW);

        SpannableString ss = new SpannableString(question);

        for (int i = 0; i < posis.size(); i++) {
            final Posi posi = posis.get(i);
            final String finalQuestion = question;
            span = new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    showDialog(finalQuestion, posi);
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }

            };
            ss.setSpan(span, posi.start, posi.end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return ss;
    }

    private void showDialog(final String text, final Posi posi) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(this);
        alert.setTitle("Enter Your Answer");
        alert.setView(edittext);

        alert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String youEditTextValue = edittext.getText().toString();
                youEditTextValue = standardizeString(youEditTextValue);
                String temp = text.substring(0, posi.start);
                String result = temp + "&" + youEditTextValue + "|";
                temp = text.substring(posi.end, text.length());
                result += temp;

                SpannableString ss = handleClickQuestion(result);
                mTvQuestion.setText(ss);
                mTvQuestion.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });

        alert.show();
    }

    private String standardizeString(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
}
