package spring.study.ja.hw1.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import spring.study.ja.hw1.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AuditoriumManager implements AuditoriumService {

    public Set<Auditorium> auditoriums = Collections.emptySet();

    private String auditoriumsInfoPath;
    private File auditoriumInfoFile;

    public AuditoriumManager() {
    }

    public AuditoriumManager(String auditoriumsInfoPath) {
        this.auditoriumsInfoPath = auditoriumsInfoPath;
    }

    public void init() {
        if (auditoriumsInfoPath.isEmpty())
            throw new IllegalArgumentException("auditoriun.info path is not set. Help!");
        auditoriumInfoFile = new File(auditoriumsInfoPath);
        if (!auditoriumInfoFile.exists())
            throw new IllegalArgumentException("auditoriun.info path can't be read to file. Help!");
        if (!auditoriumInfoFile.canWrite())
            throw new IllegalArgumentException("Can not write to auditoriun.info file. Help!");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(auditoriumInfoFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (br != null) {
            auditoriums = new HashSet<>(Arrays.asList(new Gson().fromJson(br, new TypeToken<Auditorium[]>() {
            }.getType())));
        }
    }

    @Override
    public Auditorium save(@Nonnull Auditorium object) {
        auditoriums.add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull Auditorium object) {
        auditoriums.remove(object);
    }

    @Override
    public Auditorium getById(@Nonnull Long id) {
        for (Auditorium auditorium : auditoriums
        ) {
            if (auditorium.getId().equals(id)) {
                return auditorium;
            }
        }
        return null;
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriums;
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return null;
    }
}
