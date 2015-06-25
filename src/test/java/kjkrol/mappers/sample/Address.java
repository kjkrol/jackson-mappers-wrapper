package kjkrol.mappers.sample;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Karol Krol
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {

    @NonNull
    private String city;

    @NonNull
    private String street;

    @NonNull
    private int number;

}
