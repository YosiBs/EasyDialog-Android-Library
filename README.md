<h1>SpannableTag Library</h1>





<p>
    <strong>SpannableTag</strong> is an Android library that simplifies the usage of the Spannable library by allowing developers to use custom tags in strings. The library parses these tags and applies the corresponding spannable styles to the text.
</p>

<h2><img src="https://github.com/YosiBs/Pokemon-Escape-Mobile-Game/assets/105666011/008a508e-5484-46ba-be36-ac359d603f01" alt=pic5 width="40" height="40"> Features</h2>
<ul>
    <li>Apply bold, italic, underline, strikethrough styles</li>
    <li>Set custom text sizes</li>
    <li>Change text color using hex codes</li>
    <li>Flexible and easy-to-use tagging system</li>
</ul>

<h2><img src="https://github.com/user-attachments/assets/4980fb42-e8b7-447c-86e9-007d8fb72644" alt=pic5 width="40" height="40"> Installation</h2>
<p>Add the following dependency to your <code>build.gradle</code> file:</p>
<pre><code>
dependencies {
    implementation 'com.example:spannabletag:1.0.0'
}
</code></pre>

<h2><img src="https://github.com/YosiBs/Gotcha-App/assets/105666011/0c7e3507-e910-4ac4-b5e3-8c5d484fa682" alt=pic5 width="40" height="40"> Usage</h2>
<p>To use the <strong>SpannableTag</strong> library, follow these steps:</p>

<h3>1. Initialize the SpannableParser</h3>
<pre><code>
import com.example.spannabletag.SpannableParser;
import android.text.SpannableString;
</code></pre>

<h3>2. Use Custom Tags in Your String</h3>
<pre><code>
String text = "<b>hello</b> <size.30>world</size.30>";
</code></pre>

<h3>3. Parse the String and Apply the Styles</h3>
<pre><code>
SpannableString spannableString = SpannableParser.parse(text);
textView.setText(spannableString);
</code></pre>

<h2>Supported Tags</h2>
<table>
    <thead>
        <tr>
            <th>Tag</th>
            <th>Description</th>
            <th>Example</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>&lt;b&gt;&lt;/b&gt;</td>
            <td>Bold text</td>
            <td>&lt;b&gt;bold text&lt;/b&gt;</td>
        </tr>
        <tr>
            <td>&lt;i&gt;&lt;/i&gt;</td>
            <td>Italic text</td>
            <td>&lt;i&gt;italic text&lt;/i&gt;</td>
        </tr>
        <tr>
            <td>&lt;u&gt;&lt;/u&gt;</td>
            <td>Underline text</td>
            <td>&lt;u&gt;underline text&lt;/u&gt;</td>
        </tr>
        <tr>
            <td>&lt;strike&gt;&lt;/strike&gt;</td>
            <td>Strikethrough text</td>
            <td>&lt;strike&gt;strikethrough text&lt;/strike&gt;</td>
        </tr>
        <tr>
            <td>&lt;size.{value}&gt;&lt;/size&gt;</td>
            <td>Set text size</td>
            <td>&lt;size.30&gt;large text&lt;/size.30&gt;</td>
        </tr>
        <tr>
            <td>&lt;c#{hex}&gt;&lt;/c&gt;</td>
            <td>Set text color using hex code</td>
            <td>&lt;c#ff0000&gt;red text&lt;/c&gt;</td>
        </tr>
    </tbody>
</table>

<h2><img src="https://github.com/user-attachments/assets/7908e7a2-ff92-4cb0-9101-96fc8a4efd30" alt=pic5 width="40" height="40"> Example</h2>
<pre><code>

package com.example.myapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.spannabletag.SpannableParser;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        String text = "<b>hello</b> <size.30>world</size.30>";
        textView.setText(SpannableParser.parse(text));
    }
}

</code></pre>



<h2><img src="https://github.com/user-attachments/assets/b308c9c5-3817-4490-8c0f-80c558895990" alt=pic5 width="40" height="40"> License</h2>
<p>
    <strong>SpannableTag</strong> is licensed under the MIT License. See the <code>LICENSE</code> file for more information.
</p>

<h2><img src="https://github.com/YosiBs/Gotcha-App/assets/105666011/9f5d6637-b1e1-4037-8f60-64388e5ab109" alt=pic5 width="40" height="40"> Authors</h2>
<ul>
    <li><a href="https://github.com/YosiBs">Yosi Ben Shushan</a></li>
</ul>
