package com.attraction.amy.attractionstourist.observer;

import com.attraction.amy.attractionstourist.AttractionsModel;

public interface ObserverTaipeiData {

    void onCompleted(AttractionsModel model);

    void onFail(Throwable error);

}
