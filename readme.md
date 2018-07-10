# Vector Image View

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Displays state-list drawable and level-list drawables with vector drawables without crashing below Lollipop.

Support vectors work good for single drawables, but more dynamic ones are not handled properly.
This ImageView works around the issue by parsing `selector` and `level-list` drawable xml files,
 and swapping drawables dynamically as ImageView state changes.

Does nothing for devices running Lollipop on higher aside from delegating to native implementation.

### Usage:

Ensure support vectors are enabled in your apps **build.gradle**:

```gradle
android {
    defaultConfig {
        vectorDrawables.useSupportLibrary = true
    }
}
```

Add dependency:

```gradle
    implementation "com.github.ppaszkiewicz:VectorImageView:1.0.0"
```

Use `app:vectorImageViewSrc` in layout XML:

```xml
<com.github.ppaszkiewicz.vectorimagelib.VectorImageView
    android:id="@+id/vectorImageView1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:clickable="true"
    app:vectorImageViewSrc="@drawable/custom_vector_selector" />
```

Or set drawable resource in Java code:

```java
vectorImageView.setVectorsDrawableResource(R.drawable.custom_vector_selector);
```

#### Image level

If you need to obtain current image level use `getImageLevel` method for compat implementation.

Reading vector image level directly from current drawable will always return 0 below API 21.

## Testing

Demo app contains instrumented tests that crashes ImageView (below API 21) when
used with incompatible drawables, and VectorImageView that correctly works with them.

Demo activity showcases behavior of normal ImageView and VectorImageView with selector and level-list drawables.

## License
Apache 2.0