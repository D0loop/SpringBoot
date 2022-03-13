package com.example.posting;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

/**
 * @author D0Loop
 * @since 2022-03-05 [2022.3월.05]
 */

@Component
public class GsonComponent {
    public final Gson gson;

    public GsonComponent() {
        this.gson = new Gson();
    }

    public Gson getGson() {
        return this.gson;
    }
}
