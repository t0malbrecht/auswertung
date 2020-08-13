package com.company.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader_Answers {
    private static String CSV_FILE_PATH;
    private ArrayList<AnswerObject> answerObjects = new ArrayList<>();

    public static void setCsvFilePath(String path) {
        CSV_FILE_PATH = path;
    }

    public static String getCsvFilePath() {
        return CSV_FILE_PATH;
    }

    public ArrayList<AnswerObject> getList() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("Recht, Gesetze", "Verkauf", "Organisation und Verwaltung", "Komplexe Probleme lÃ¶sen", "Sprachen/Fremdsprachen", "Geschichtliche Entwicklungen", "Technische Zeichnungen", "Politik", "Physikalisch, chemische, biologische VorgÃ¤nge nachvollziehen", "Andere Menschen", "Wissenschaftliche Fragestellungen", "Theoretische Modelle Ã¼berprÃ¼fen/verbessern", "Medizin", "Kreative TÃ¤tigkeiten", "Finanzen und Geld", "Naturwissenschaften", "Bau, Vermessungen, Technik, Entwicklung", "Landwirtschaft", "Geist und Seele", "Literatur", "menschliches Wohlbefinden", "Strukturen und Funktionen technischer Sachsysteme und Prozesse", "Kunst, Musik, Kultur", "FÃ¼hrung und Koordination", "Andere Menschen beim ProblemlÃ¶sen unterstÃ¼tzen", "Wirtschaftliche Strategien", "Greifbare Resultate", "Systematische Untersuchungen", "Regelbasiertes Vorgehen", "Unterricht und Fortbildung", "Ã„sthetik", "Gesundheit", "Philosophie", "Computer, neue Technologien, Medien", "Sport", "Phantasie", "Unkonventionelle Ideen", "Gesellschaft", "Psychische Gesundheit", "Wissen-, Fertigkeitenvermittlung", "Planen, Konstruieren, Herstellen, Bewerten, Verwenden und Entsorgen", "VerantwortungsÃ¼bernahme", "Religion", "Eigene Ziele durchsetzen", "Ich erinnere mich an verpasste MÃ¶glichkeiten.", "Ich mag, wenn alles in meinem Leben organisiert und geplant ist.", "Ich versuche ein Problem zu verstehen, indem ich mir die Theorien ansehe.", "Ich bin von meinem Herzen geleitet.", "Ich bin warmherzig.", "Mich interessieren die zukÃ¼nftigen MÃ¶glichkeiten.", "Ich versuche stÃ¤ndig neue Leute kennen zu lernen.", "Ich analysiere alle Vor- und Nachteile, bevor ich eine Entscheidung treffe.", "Ich plane meine Reisen kurzfristig.", "Ich treffe eine Wahl eher impulsiv.", "Logik ist fÃ¼r mich wichtiger als die GefÃ¼hle.", "Ich mag es, wenn mir ungeplante Sachen passieren.", "Ich will stabile und gegenseitig warme Beziehungen zu den anderen knÃ¼pfen.", "Ich finde immer ein GesprÃ¤chsthema.", "FÃ¼r mich gilt: Erst die Arbeit und dann das VergnÃ¼gen.", "Ich sammle lieber neue Erfahrungen, als BÃ¼cher zu lesen.", "Ich bin mehr interessiert an dem, was tatsÃ¤chlich ist, als an dem, was sein kÃ¶nnte.", "Es gefÃ¤llt mir, meine Aufgaben spielerisch zu erledigen.", "Ich will immer wissen, wie die Sachen funktionieren.", "Ich wÃ¤hle meinen Sitzplatz in der Ecke des Zimmers.", "Ich folge immer den Regeln.", "FÃ¼r andere Menschen ist es eher schwierig mich kennenzulernen.", "Die Improvisation ist mir wichtiger als das planvolle Arbeiten.", "Ich warte, bis ich angesprochen werde.", "Ich fÃ¼hle mich involviert, wenn ich Filme anschaue.", "Ich bin ein quirlig-gesprÃ¤chiger Mensch.", "Wenn ich von vielen Menschen umgeben bin, fÃ¼hle ich mich wohl.", "Beim ProblemlÃ¶sen folge ich lieber den geprÃ¼ften Methoden.", "Ich werde von meinem Verstand geleitet.", "Ich bin ordentlich.", "Ich beschÃ¤ftige mich mit etwas erst dann, wenn ich Lust dazu habe.", "Ich treffe wichtige Entscheidungen, indem ich mit jemandem darÃ¼ber spreche.", "Die Idee interessiert mich mehr, als die Realisation.", "Ich sehe mich selbst eher als einen ruhig-zurÃ¼ckhaltenden Menschen.","Studierst du momentan?",	"Wie zufrieden bist du mit deinem Studiengang?",	"Wie sinnvoll findest du Algorithmen, welche dir Entscheidungsfindung helfen? (z.B. beim Wahlomat oder ProduktvorschlÃ¤ge)",	"Welchen Studiengang wÃ¼rdet du wÃ¤hlen, wenn du dich jetzt entscheiden mÃ¼sstest?",	"Was studierst du momentan?",	"Wie sinnvoll findest du Algorithmen, welche dir Entscheidungsfindung helfen? (z.B. beim Wahlomat oder ProduktvorschlÃ¤ge)2")
                        .withIgnoreHeaderCase()
                        .withTrim())

        ) {
            List<CSVRecord> csvRecord = csvParser.getRecords().stream()
                    .filter(record -> record.getRecordNumber() != 1)
                    .collect(Collectors.toList());
            for (CSVRecord csvRecord1 : csvRecord) {
                HashMap<Integer,Integer> temp = new HashMap<>();
                temp.put(1,Integer.parseInt(csvRecord1.get("Recht, Gesetze")));
                temp.put(2,Integer.parseInt(csvRecord1.get("Verkauf")));
                temp.put(3,Integer.parseInt(csvRecord1.get("Organisation und Verwaltung")));
                temp.put(4,Integer.parseInt(csvRecord1.get("Komplexe Probleme lÃ¶sen")));
                temp.put(5,Integer.parseInt(csvRecord1.get("Sprachen/Fremdsprachen")));
                temp.put(6,Integer.parseInt(csvRecord1.get("Geschichtliche Entwicklungen")));
                temp.put(7,Integer.parseInt(csvRecord1.get("Technische Zeichnungen")));
                temp.put(8,Integer.parseInt(csvRecord1.get("Politik")));
                temp.put(9,Integer.parseInt(csvRecord1.get("Physikalisch, chemische, biologische VorgÃ¤nge nachvollziehen")));
                temp.put(10,Integer.parseInt(csvRecord1.get("Andere Menschen")));
                temp.put(11,Integer.parseInt(csvRecord1.get("Wissenschaftliche Fragestellungen")));
                temp.put(12,Integer.parseInt(csvRecord1.get("Theoretische Modelle Ã¼berprÃ¼fen/verbessern")));
                temp.put(13,Integer.parseInt(csvRecord1.get("Medizin")));
                temp.put(14,Integer.parseInt(csvRecord1.get("Kreative TÃ¤tigkeiten")));
                temp.put(15,Integer.parseInt(csvRecord1.get("Finanzen und Geld")));
                temp.put(16,Integer.parseInt(csvRecord1.get("Naturwissenschaften")));
                temp.put(17,Integer.parseInt(csvRecord1.get("Bau, Vermessungen, Technik, Entwicklung")));
                temp.put(18,Integer.parseInt(csvRecord1.get("Landwirtschaft")));
                temp.put(19,Integer.parseInt(csvRecord1.get("Geist und Seele")));
                temp.put(20,Integer.parseInt(csvRecord1.get("Literatur")));
                temp.put(21,Integer.parseInt(csvRecord1.get("menschliches Wohlbefinden")));
                temp.put(22,Integer.parseInt(csvRecord1.get("Strukturen und Funktionen technischer Sachsysteme und Prozesse")));
                temp.put(23,Integer.parseInt(csvRecord1.get("Kunst, Musik, Kultur")));
                temp.put(24,Integer.parseInt(csvRecord1.get("FÃ¼hrung und Koordination")));
                temp.put(25,Integer.parseInt(csvRecord1.get("Andere Menschen beim ProblemlÃ¶sen unterstÃ¼tzen")));
                temp.put(26,Integer.parseInt(csvRecord1.get("Wirtschaftliche Strategien")));
                temp.put(27,Integer.parseInt(csvRecord1.get("Greifbare Resultate")));
                temp.put(28,Integer.parseInt(csvRecord1.get("Systematische Untersuchungen")));
                temp.put(29,Integer.parseInt(csvRecord1.get("Regelbasiertes Vorgehen")));
                temp.put(30,Integer.parseInt(csvRecord1.get("Unterricht und Fortbildung")));
                temp.put(31,Integer.parseInt(csvRecord1.get("Ã„sthetik")));
                temp.put(32,Integer.parseInt(csvRecord1.get("Gesundheit")));
                temp.put(33,Integer.parseInt(csvRecord1.get("Philosophie")));
                temp.put(34,Integer.parseInt(csvRecord1.get("Computer, neue Technologien, Medien")));
                temp.put(35,Integer.parseInt(csvRecord1.get("Sport")));
                temp.put(36,Integer.parseInt(csvRecord1.get("Phantasie")));
                temp.put(37,Integer.parseInt(csvRecord1.get("Unkonventionelle Ideen")));
                temp.put(38,Integer.parseInt(csvRecord1.get("Gesellschaft")));
                temp.put(39,Integer.parseInt(csvRecord1.get("Psychische Gesundheit")));
                temp.put(40,Integer.parseInt(csvRecord1.get("Wissen-, Fertigkeitenvermittlung")));
                temp.put(41,Integer.parseInt(csvRecord1.get("Planen, Konstruieren, Herstellen, Bewerten, Verwenden und Entsorgen")));
                temp.put(42,Integer.parseInt(csvRecord1.get("VerantwortungsÃ¼bernahme")));
                temp.put(43,Integer.parseInt(csvRecord1.get("Religion")));
                temp.put(44,Integer.parseInt(csvRecord1.get("Eigene Ziele durchsetzen")));
                temp.put(45,Integer.parseInt(csvRecord1.get("Ich erinnere mich an verpasste MÃ¶glichkeiten.")));
                temp.put(46,Integer.parseInt(csvRecord1.get("Ich mag, wenn alles in meinem Leben organisiert und geplant ist.")));
                temp.put(47,Integer.parseInt(csvRecord1.get("Ich versuche ein Problem zu verstehen, indem ich mir die Theorien ansehe.")));
                temp.put(48,Integer.parseInt(csvRecord1.get("Ich bin von meinem Herzen geleitet.")));
                temp.put(49,Integer.parseInt(csvRecord1.get("Ich bin warmherzig.")));
                temp.put(50,Integer.parseInt(csvRecord1.get("Mich interessieren die zukÃ¼nftigen MÃ¶glichkeiten.")));
                temp.put(51,Integer.parseInt(csvRecord1.get("Ich versuche stÃ¤ndig neue Leute kennen zu lernen.")));
                temp.put(52,Integer.parseInt(csvRecord1.get("Ich analysiere alle Vor- und Nachteile, bevor ich eine Entscheidung treffe.")));
                temp.put(53,Integer.parseInt(csvRecord1.get("Ich plane meine Reisen kurzfristig.")));
                temp.put(54,Integer.parseInt(csvRecord1.get("Ich treffe eine Wahl eher impulsiv.")));
                temp.put(55,Integer.parseInt(csvRecord1.get("Logik ist fÃ¼r mich wichtiger als die GefÃ¼hle.")));
                temp.put(56,Integer.parseInt(csvRecord1.get("Ich mag es, wenn mir ungeplante Sachen passieren.")));
                temp.put(57,Integer.parseInt(csvRecord1.get("Ich will stabile und gegenseitig warme Beziehungen zu den anderen knÃ¼pfen.")));
                temp.put(58,Integer.parseInt(csvRecord1.get("Ich finde immer ein GesprÃ¤chsthema.")));
                temp.put(59,Integer.parseInt(csvRecord1.get("FÃ¼r mich gilt: Erst die Arbeit und dann das VergnÃ¼gen.")));
                temp.put(60,Integer.parseInt(csvRecord1.get("Ich sammle lieber neue Erfahrungen, als BÃ¼cher zu lesen.")));
                temp.put(61,Integer.parseInt(csvRecord1.get("Ich bin mehr interessiert an dem, was tatsÃ¤chlich ist, als an dem, was sein kÃ¶nnte.")));
                temp.put(62,Integer.parseInt(csvRecord1.get("Es gefÃ¤llt mir, meine Aufgaben spielerisch zu erledigen.")));
                temp.put(63,Integer.parseInt(csvRecord1.get("Ich will immer wissen, wie die Sachen funktionieren.")));
                temp.put(64,Integer.parseInt(csvRecord1.get("Ich wÃ¤hle meinen Sitzplatz in der Ecke des Zimmers.")));
                temp.put(65,Integer.parseInt(csvRecord1.get("Ich folge immer den Regeln.")));
                temp.put(66,Integer.parseInt(csvRecord1.get("FÃ¼r andere Menschen ist es eher schwierig mich kennenzulernen.")));
                temp.put(67,Integer.parseInt(csvRecord1.get("Die Improvisation ist mir wichtiger als das planvolle Arbeiten.")));
                temp.put(68,Integer.parseInt(csvRecord1.get("Ich warte, bis ich angesprochen werde.")));
                temp.put(69,Integer.parseInt(csvRecord1.get("Ich fÃ¼hle mich involviert, wenn ich Filme anschaue.")));
                temp.put(70,Integer.parseInt(csvRecord1.get("Ich bin ein quirlig-gesprÃ¤chiger Mensch.")));
                temp.put(71,Integer.parseInt(csvRecord1.get("Wenn ich von vielen Menschen umgeben bin, fÃ¼hle ich mich wohl.")));
                temp.put(72,Integer.parseInt(csvRecord1.get("Beim ProblemlÃ¶sen folge ich lieber den geprÃ¼ften Methoden.")));
                temp.put(73,Integer.parseInt(csvRecord1.get("Ich werde von meinem Verstand geleitet.")));
                temp.put(74,Integer.parseInt(csvRecord1.get("Ich bin ordentlich.")));
                temp.put(75,Integer.parseInt(csvRecord1.get("Ich beschÃ¤ftige mich mit etwas erst dann, wenn ich Lust dazu habe.")));
                temp.put(76,Integer.parseInt(csvRecord1.get("Ich treffe wichtige Entscheidungen, indem ich mit jemandem darÃ¼ber spreche.")));
                temp.put(77,Integer.parseInt(csvRecord1.get("Die Idee interessiert mich mehr, als die Realisation.")));
                temp.put(78,Integer.parseInt(csvRecord1.get("Ich sehe mich selbst eher als einen ruhig-zurÃ¼ckhaltenden Menschen.")));
                ArrayList<String> temp2 = new ArrayList<>();
                temp2.add(csvRecord1.get("Studierst du momentan?"));
                temp2.add(csvRecord1.get("Wie zufrieden bist du mit deinem Studiengang?"));
                temp2.add(csvRecord1.get("Wie sinnvoll findest du Algorithmen, welche dir Entscheidungsfindung helfen? (z.B. beim Wahlomat oder ProduktvorschlÃ¤ge)"));
                temp2.add(csvRecord1.get("Welchen Studiengang wÃ¼rdet du wÃ¤hlen, wenn du dich jetzt entscheiden mÃ¼sstest?"));
                temp2.add(csvRecord1.get("Was studierst du momentan?"));
                temp2.add(csvRecord1.get("Wie sinnvoll findest du Algorithmen, welche dir Entscheidungsfindung helfen? (z.B. beim Wahlomat oder ProduktvorschlÃ¤ge)2"));
                answerObjects.add(new AnswerObject(temp, temp2));

            }
        }
        return answerObjects;
    }

}