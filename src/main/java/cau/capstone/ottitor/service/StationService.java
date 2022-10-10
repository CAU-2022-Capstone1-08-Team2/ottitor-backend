package cau.capstone.ottitor.service;


import cau.capstone.ottitor.domain.Station;
import cau.capstone.ottitor.repository.StationRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class StationService {

    private final StationRepository stationRepository;

    private final List<String> lineNumList = List.of("01호선", "02호선", "03호선");

    public void initialize() {
        lineNumList.forEach(this::initializeByLineNum);
    }

    private void initializeByLineNum(String lineNum) {
//        if (!stationRepository.findByLineNumOrderByFrCodeAsc(lineNum).isEmpty()) {
//            return;
//        }

        BufferedReader file = null;
        try {
            file = new BufferedReader(
                new FileReader(
                    String.format("%s/src/main/resources/station/%s.csv", System.getProperty("user.dir"), lineNum)
                ));
            String line;

            while ((line = file.readLine()) != null) {
                line = line.replace("\uFEFF", "");
                List<String> rows = Arrays.asList(line.split(","));
                Station station =  Station.builder().code(rows.get(0)).nmKor(rows.get(1)).nmEng(rows.get(2)).lineNum(rows.get(3)).frCode(rows.get(4)).mnt(Integer.parseInt(rows.size() > 5 ? rows.get(5) : "0")).directAt(Integer.parseInt(rows.size() > 6 ? rows.get(6) : "0")).build();

                stationRepository.save(station);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
