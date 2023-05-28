package hu.peterlazsan.smith.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hu.peterlazsan.smith.model.dao.Smith;
import hu.peterlazsan.smith.model.other.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmithingJob {
    private Item smithWork;
    private Smith smith;


}
