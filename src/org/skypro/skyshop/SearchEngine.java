package org.skypro.skyshop;

import java.util.*;

public class SearchEngine {
    private List<Searchable> elements = new ArrayList<>();

    public void add(Searchable item) {
        elements.add(item);
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable element : elements) {
            if (element.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(element);
            }
        }
        return results;
    }

    public TreeMap<String, Searchable> searchMap(String searchTerm) {
        TreeMap<String, Searchable> results = new TreeMap<>();
        for (Searchable element : elements) {
            if (element.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.put(element.getName(), element);
            }
        }
        return results;
    }

    public Searchable findBest(String search) throws BestResultNotFound {
        Searchable best = null;
        int maxCount = -1;

        for (Searchable element : elements) {
            if (element == null) continue;

            String term = element.getSearchTerm();
            int count = 0;
            int index = 0;

            while ((index = term.indexOf(search, index)) != -1) {
                count++;
                index += search.length();
            }

            if (count > maxCount) {
                maxCount = count;
                best = element;
            }
        }

        if (best == null) {
            throw new BestResultNotFound(search);
        }
        return best;
    }
}

