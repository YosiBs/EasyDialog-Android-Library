<h1>SpannableTag Library</h1>
<p>
    <strong>SpannableTag</strong> is an Android library that simplifies the usage of the Spannable library by allowing developers to use custom tags in strings. The library parses these tags and applies the corresponding spannable styles to the text.
</p>


<img src="https://github.com/user-attachments/assets/4a59f3a2-d610-4ebd-aaaa-58fa07225504" alt=pic5 width="250">

<h2><img src="https://github.com/YosiBs/Pokemon-Escape-Mobile-Game/assets/105666011/008a508e-5484-46ba-be36-ac359d603f01" alt=pic5 width="40" height="40"> Features</h2>
<ul>
    <li><strong>Foreground Color:</strong> Apply custom foreground colors using hex codes. For example, <code>&lt;c#ff0000&gt;red text&lt;/c#ff0000&gt;</code> will make "red text" appear in red.</li>
    <li><strong>Background Color:</strong> Apply custom background colors using hex codes. For example, <code>&lt;bg#00ff00&gt;green background&lt;/bg#00ff00&gt;</code> will make "green background" text have a green background.</li>
    <li><strong>Bold:</strong> Make text bold. For example, <code>&lt;b&gt;bold text&lt;/b&gt;</code> will make "bold text" bold.</li>
    <li><strong>Italic:</strong> Make text italic. For example, <code>&lt;i&gt;italic text&lt;/i&gt;</code> will make "italic text" italic.</li>
    <li><strong>Underline:</strong> Underline text. For example, <code>&lt;u&gt;underlined text&lt;/u&gt;</code> will underline "underlined text".</li>
    <li><strong>Strikethrough:</strong> Apply strikethrough to text. For example, <code>&lt;strike&gt;strikethrough text&lt;/strike&gt;</code> will add a strikethrough to "strikethrough text".</li>
    <li><strong>Text Size:</strong> Set custom text sizes. For example, <code>&lt;size.2&gt;large text&lt;/size.2&gt;</code> will make "large text" have a size of 2.</li>
</ul>

<h2><img src="https://github.com/user-attachments/assets/4980fb42-e8b7-447c-86e9-007d8fb72644" alt=pic5 width="40" height="40"> Installation</h2>

<a href="https://jitpack.io/#YosiBs/SpannableTag-Android-Library"><img src="https://jitpack.io/v/YosiBs/SpannableTag-Android-Library.svg" alt=pic5 width="100"></a>

<p>Add the following dependency to your <code>build.gradle</code> file:</p>
<pre><code>
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
</code></pre>

<pre><code>
dependencies {
    implementation 'com.github.YosiBs:SpannableTag-Android-Library:Tag'
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
String text = "<b>hello</b> <size.2>world</size.2>";
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
            <td>&lt;size.{value}&gt;&lt;/size.{value}&gt;</td>
            <td>Set text size</td>
            <td>&lt;size.2&gt;large text&lt;/size.2&gt;</td>
        </tr>
        <tr>
            <td>&lt;c#{hex}&gt;&lt;/c#{hex}&gt;</td>
            <td>Set text color using hex code</td>
            <td>&lt;c#ff0000&gt;red text&lt;/c#ff0000&gt;</td>
        </tr>
    </tbody>
</table>

<h2><img src="https://github.com/user-attachments/assets/7908e7a2-ff92-4cb0-9101-96fc8a4efd30" alt=pic5 width="40" height="40"> Example</h2>
<p>Input:</p>

<img src="https://github.com/user-attachments/assets/092e9816-bed1-4aa9-8577-148f6e78cf75" alt=pic5 width="2000">
<p>Output:</p>
<img src="https://github.com/user-attachments/assets/4b9917ee-b04c-46cf-a861-ef9f4c6d0ac2" alt=pic5 width="300">

<h2><img src="https://github.com/user-attachments/assets/b308c9c5-3817-4490-8c0f-80c558895990" alt=pic5 width="40" height="40"> License</h2>
<p>
    <strong>SpannableTag</strong> is licensed under the MIT License. See the <code>LICENSE</code> file for more information.
</p>

<h2><img src="https://github.com/YosiBs/Gotcha-App/assets/105666011/9f5d6637-b1e1-4037-8f60-64388e5ab109" alt=pic5 width="40" height="40"> Authors</h2>
<ul>
    <li><a href="https://github.com/YosiBs">Yosi Ben Shushan</a></li>
</ul>
