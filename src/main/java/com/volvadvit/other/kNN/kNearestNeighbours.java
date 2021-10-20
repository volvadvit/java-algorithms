package com.volvadvit.other.kNN;

import java.util.*;
import java.util.stream.Collectors;

/** Алгоритм поиска К-ближайших соседей.
 *
 * Подходит для:
 * классификации (распределение по категориям, рекомендаци),
 * регрессии (прогноз на основе имеющихся данных).
 *
 * Схожесть объектов вычисляется по теореме Пифагора: sqrt( (x1-x2)^2 + (y1-y2)^2 + ...),
 * где x,y - некие признаки объектов.
 */
public class kNearestNeighbours {

    public static void main(String[] args) {
        // New Model
        Model newModel = new Model("Me", 4, 3, 1);

        // Set up
        Model neo = new Model("Neo", 5, 1, 2);
        Model bilbo = new Model("Bilbo", 3, 3, 3);
        Model luke = new Model("Luke", 3, 2, 4);
        Model jack = new Model("Jack", 1, 3, 5);
        Model forrest = new Model("Forrest", 3, 1, 4);

        List<Model> modelList = new ArrayList<>(List.of(neo, bilbo, luke, jack, forrest));

        // Neighbours count: Must be determined like optimal value for current list size, but for test we took const
        int k = (modelList.size() / 2) + 1;

        Map<Model, Double> rangeMapForNewModel = getRangeMapForModel(newModel, modelList);

        // Classification
        List<Model> nearestModels = getNearestNeighbours(newModel, rangeMapForNewModel, k);
        System.err.println("Most similar models: " + nearestModels);
        // Regression
        System.err.println("Average scores for neighboring models : " + getRegressionValues(nearestModels));
    }

    private static Map<String, Double> getRegressionValues(List<Model> nearestModels) {
        Map<String, Double> averageScoresMap = new HashMap<>(Map.of(
                "comedy", 0.0,
                "action", 0.0,
                "drama", 0.0
        ));

        for (Model neighbor : nearestModels) {
            averageScoresMap.put("comedy", averageScoresMap.get("comedy") + neighbor.comedy);
            averageScoresMap.put("action", averageScoresMap.get("action") + neighbor.action);
            averageScoresMap.put("drama", averageScoresMap.get("drama") + neighbor.drama);
        }

        for (Map.Entry<String, Double> entry : averageScoresMap.entrySet()) {
            double score = entry.getValue();
            entry.setValue(score / averageScoresMap.size());
        }

        return averageScoresMap;
    }

    private static List<Model> getNearestNeighbours(Model newModel, Map<Model, Double> modelsMeasureMap, int k) {
        // Sort map and take fist "k" models
        return modelsMeasureMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .limit(k)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
    }

    private static Map<Model, Double> getRangeMapForModel(Model newModel, List<Model> modelList) {
        Map<Model, Double> outputRangeMap = new HashMap<>();

        for (Model compareModel : modelList) {
            double range = Math.sqrt(
                    Math.pow((newModel.drama - compareModel.drama), 2) +
                    Math.pow((newModel.action - compareModel.action), 2) +
                    Math.pow((newModel.comedy - compareModel.comedy), 2)
            );
            outputRangeMap.put(compareModel, range);
        }
        return outputRangeMap;
    }
}
