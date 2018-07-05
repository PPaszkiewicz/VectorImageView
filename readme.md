# Vector Image View

Displays state-list drawable and level-list drawables with vector drawables without crashing below Lollipop.

Support vectors work good for static drawables, but more dynamic ones are not handled properly.
This ImageView works around the issue by parsing `selector` and `level-list` drawable xml files, and swapping drawables dynamically as ImageView state changes.

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

Use in layout XML:

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


## License

Copyright 2018 Paweł Paszkiewicz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.