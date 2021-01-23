package ru.netologt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager fileOpenManager = new FileOpenManager();

    private String windows = "Paint";
    private String office = "Excel";
    private String autodesk = "AutoCAD";

    private String png = ".png";
    private String xlc  = ".xlc";
    private String dwg  = ".dwg";

    @BeforeEach
    void setUp() {
        fileOpenManager.register(png, windows);
        fileOpenManager.register(xlc, office);
        fileOpenManager.register(dwg, autodesk);
    }
    @Test
    void shouldGetAllApps() {
        Set<String> actual = fileOpenManager.getAllApps();
        Set<String> expected = new HashSet<>();
        expected.add(windows);
        expected.add(office);
        expected.add(autodesk);
        assertEquals(expected, actual);
    }


    @Test
    void shouldGetAllExtension() {
        Collection<String> actual = fileOpenManager.getAllExtension();
        List<String> expected = Arrays.asList(xlc, png, dwg);
        assertEquals(expected, actual);
    }


    @Test
    void shouldGetNameByType() {
        String expected = "Excel";
        String actual = fileOpenManager.getName(".xlc");
        assertEquals(expected, actual);
    }


    @Test
    void shouldGetNameByTypeUpperCase() {
        String expected = "AutoCAD";
        String actual = fileOpenManager.getName(".DWG");
        assertEquals(expected, actual);
    }


    @Test
    void shouldNotGetNameByType() {
        String actual = fileOpenManager.getName(".jpg");
        assertNull(actual);
    }


    @Test
    void shouldRemove() {
        String actual = fileOpenManager.remove("Paint");
        assertNull(actual);
    }
}