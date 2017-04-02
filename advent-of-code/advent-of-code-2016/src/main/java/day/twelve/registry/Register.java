package day.twelve.registry;

import lombok.Data;

/**
 * Created by Pawel on 2016-12-12.
 */

@Data
public class Register {

    private String registryId;
    private int registryValue;

    public Register(String registryId) {
        this.registryId = registryId;
    }
}
