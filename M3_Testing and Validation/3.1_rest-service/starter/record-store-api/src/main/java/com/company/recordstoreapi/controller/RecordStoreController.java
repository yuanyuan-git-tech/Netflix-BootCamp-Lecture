package com.company.recordstoreapi.controller;

import com.company.recordstoreapi.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecordStoreController {

    private List<Record> recordList;

    private static int idCounter = 1;

    public RecordStoreController() {
        recordList = new ArrayList<>();

        recordList.add(new Record("The Beach Boys", "Pet Sounds", "1968", idCounter++));
        recordList.add(new Record("Billy Joel", "The Stranger", "1977", idCounter++));
        recordList.add(new Record("The Beatles", "Revolver", "1964", idCounter++));
        recordList.add(new Record("Kanye West", "My Beautiful Dark Twisted Fantasy", "2008", idCounter++));
        recordList.add(new Record("Sturgill Simpson", "Metamodern Sounds in Country Music", "2010", idCounter++));
    }

    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Record createRecord(@RequestBody Record record) {

        record.setId(idCounter++);
        recordList.add(record);

        return record;
    }
}
