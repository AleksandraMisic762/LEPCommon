package rs.ac.bg.fon.ai.npcommon.communication;

import java.io.Serializable;

public enum Operation  implements Serializable{
    LOGIN,
    GET_ALL_EKSPERIMENT,
    GET_ALL_EKSPERIMENTATOR,
    GET_ALL_PREDMET,
    KREIRAJ_STUDENTA,
    ZAPAMTI_STUDENTA,
    PRETRAZI_STUDENTA,
    ZAPAMTI_UCESCE,
    KREIRAJ_EKSPERIMENT,
    ZAPAMTI_EKSPERIMENT,
    OBRISI_EKSPERIMENT,
    PRETRAZI_EKSPERIMENT,
    KREIRAJ_LISTU_STUDENTA,
    ZAPAMTI_LISTU_STUDENTA,
    KREIRAJ_RASPORED_EKSPERIMENATA,
    ZAPAMTI_RASPORED_EKSPERIMENATA,
    KREIRAJ_EKSPERIMENTATORA,
    ZAPAMTI_EKSPERIMENTATORA,
    GET_ALL_STUDENT_USLOV,
    GET_ALL_UCESCA_NA_EKSPERIMENTU
}