package cz.speedygonzales.concurrency.scheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: vondracek - 27.2.15 10:32
 */
public class Processor {

    private List<Record> records;

    public Processor(List<Record> records) {

        this.records = records;

        if (this.records == null) {
            this.records = new ArrayList<Record>();
        }
    }

    public List<Record> doProcess() {

        if (this.records.size() > 0) {
            this.records.remove(this.records.size() - 1);
            System.out.println("Procesuji data");
        }
        return this.records;
    }
}
