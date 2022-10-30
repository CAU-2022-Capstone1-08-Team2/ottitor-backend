package cau.capstone.ottitor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class StationInfo extends BaseTimeEntity {

    @Id
    private String statnId;

    @Column
    private String subwayId;

    @Column
    private String statnNm;

    @Builder
    public StationInfo(String subwayId, String statnId, String statnNm) {
        this.subwayId = subwayId;
        this.statnId = statnId;
        this.statnNm = statnNm;
    }
}
