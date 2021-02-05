package org.colocation;

import org.cloudbus.cloudsim.Log;
import org.colocation.scheduler.ResourcePredictor;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by wkj on 2019/6/6.
 */
public class PredictorTest {
    int[] testData = {53,58,58,59,60,63,60,61,58,59,64,63,60,60,60,63,57,59,60,59,60,60,60,62,62,63,59,60,61,58,59,59,60,63,59,60,59,59,59,61,59,59,60,63,60,65,66,67,65,61,60,63,65,61,62,63,61,61,60,59,60,60,62,57,59,57,58,59,58,58,58,61,61,57,59,58,58,56,58,59,62,57,58,56,58,60,58,58,58,57,59,56,56,57,55,56,55,56,58,60,57,55,56,55,55,54,56,56,58,58,53,53,53,54,56,54,54,56,59,55,52,60,59,60,60,60,61,62,62,60,60,60,60,60,59,59,60,61,58,60,59,59,59,59,58,59,60,60,58,59,59,58,58,58,59,60,58,59,58,59,58,57,57,56,57,59,56,57,57,55,57,57,57,59,59,60,56,58,57,56,54,47,48,53,51,47,47,49,48,48,47,49,48,52,52,48,47,46,46,49,49,52,53,50,48,48,50,48,45,47,46,50,51,46,47,46,46,47,46,46,48,52,50,44,46,46,46,45,44,43,49,45,45,43,46,44,45,46,48,43,48,41,42,43,41,41,40,41,44,43,45,38,40,40,41,38,38,40,40,42,38,36,38,37,36,35,37,36,38,38,34,35,33,34,33,35,36,36,35,32,35,32,36,30,31,31,35,36,32,30,31,31,32,30,43,38,42,38,31,35,32,37,38,37,37,39,38,41,35,38,36,36,34,36,35,38,33,35,35,35,35,34,35,35,39,38,35,35,33,33,34,34,34,37,37,36,32,33,33,33,34,32,34,37,33,33,31,34,33,32,31,34,32,38,31,32,32,31,31,32,33,43,39,41,35,38,36,39,35,36,35,42,36,36,36,36,36,36,36,36,35,38,33,35,36,36,35,36,35,39,37,39,34,35,35,34,34,34,34,38,32,35,35,34,34,32,33,36,33,36,31,33,32,31,32,33,32,35,35,34,30,32,33,33,31,31,32,34,33,30,30,31,31,32,30,31,32,32,30,31,30,30,32,30,31,33,33,33,29,31,29,29,29,29,30,32,31,29,29,30,29,30,28,29,29,31,27,29,29,27,28,28,29,29,32,31,28,30,28,27,27,26,26,29,29,25,26,26,27,27,26,27,25,29,24,25,26,25,26,26,25,27,29,27,25,25,26,24,27,24,25,28,28,26,25,25,25,27,25,26,26,33,24,25,25,26,25,25,24,26,25,28,25,25,25,25,26,25,25,29,27,28,25,25,26,29,25,25,26,29,25,26,27,26,25,25,25,25,25,30,24,19,16,16,17,18,17,21,20,21,17,18,17,17,16,17,17,22,16,17,17,20,17,17,18,17,16,23,15,17,18,18,17,17,17,22,19,21,16,18,18,18,16,20,18,22,19,21,17,19,18,18,17,18,17,22,20,20,19,18,18,20,18,20,21,22,17,20,18,18,18,18,18,21,19,20,17,19,19,19,18,19,20,22,17,19,18,21,19,19,20,22,22,22,17,19,19,21,19,19,20,27,24,22,23,25,24,23,24,26,27,28,24,25,24,25,23,26,24,25,28,28,24,26,25,25,25,26,27,29,30,29,24,27,26,26,25,26,29,32,27,30,29,27,28,28,27,29,32,31,28,29,29,28,30,30,31,35,34,33,30,28,28,29,29,28,29,34,28,32,30,31,30,32,31,31,31,34,29,32,31,32,32,32,34,43,36,39,32,35,33,34,32,34,35,38,34,35,36,37,34,37,36,35,36,39,36,38,35,36,37,37,37,41,41,42,38,40,39,40,38,32,33,37,34,33,31,33,33,33,33,36,34,38,33,34,34,34,35,34,34,39,38,39,35,37,37,37,34,37,36,42,37,37,35,36,37,37,36,37,39,45,38,39,40,37,38,39,38,41,42,42,38,39,40,40,39,39,41,45,43,41,42,42,42,42,42,42,41,46,44,42,43,46,45,43,43,45,46,45,43,43,44,44,44,44,44,47,48,44,44,44,46,45,45,45,47,49,50,45,45,48,45,46,47,46,50,50,48,45,48,46,47,46,47,48,50,47,48,47,45,51,51,51,52,54,53,50,51,50,51,50,51,52,55,54,50,50,51,52,50,51,50,50,54,48,51,51,52,51,51,51,54,52,53,49,50,52,51,50,49,52,54,53,51,52,51,51,50,51,51,50,53,47,51,53,50,51,50,50,53,51,52,45,50,49,48,48,48,49,53,50,47,48,49,47,49,50,47,47,51,50,46,48,48,47,47,48,47,51,50,49,45,47,47,48,47,47,48,49,48,48,46,46,48,54,54,56,54,51,44,45,47,48,49,52,57,58,51,50,48,51,51,50,50,50,50,55,49,56,50,49,49,51,52,50,52,52,51,51,49,50,49,48,51,52,54,48,50,50,49,50,48,48,51,51,53,46,49,48,46,50,49,48,51,52,52,50,50,50,49,48,49,49,55,49,49,48,49,49,51,43,44,46,47,44,44,43,42,44,43,45,48,43,48,42,44,46,44,45,47,43,46,41,43,43,43,45,44,44,45,52,46,43,43,45,44,43,44,42,45,50,47,42,43,45,43,47,43,44,46,48,41,44,42,43,45,44,43,48,48,49,43,47,48,44,44,46,49,47,43,42,46,42,43,43,44,42,47,45,41,43,41,39,41,42,41,42,44,44,40,40,42,40,37,39,41,47,38,39,40,40,42,39,38,40,42,48,37,40,38,39,43,39,39,44,42,44,38,40,40,41,39,41,40,47,40,42,41,41,42,43,43,44,46,45,41,42,43,42,42,43,42,49,46,45,41,43,43,42,40,42,43,48,40,43,43,44,44,44,43,46,48,48,40,43,43,46,44,43,43,46,46,43,42,44,42,43,43,45,43,45,46,40,42,45,40,43,42,42,45,46,46,42,47,45,44,44,42,43,45,42,41,42,43,44,43,43,43,48,46,42,43,45,42,43,44,44,47,47,45,43,44,44,43,44,45,45,47,43,44,43,42,44,43,45,44,48,48,44,46,47,45,45,43,45,49,51,48,44,46,45,45,45,46,48,49,51,45,46,45,46,45,46,45,49,51,52,45,46,47,48,44,47,50,51,46,48,47,47,47,48,47,50,53,59,53,60,55,50,50,50,50,52,55,57,54,58,58,56,52,50,51,54,51,51,51,50,52,52,50,52,53,53,51,51,52,50,49,50,51,54,58,51,51,51,51,54,52,51,52,54,55,50,52,50,50,50,51,52,55,52,55,52,52,52,51,52,53,52,57,51,52,53,53,54,54,54,54,57,58,48,51,48,49,49,51,51,55,53,53,47,50,51,50,49,52,51,55,48,51,51,50,51,52,55,53,54,54,53,54,51,51,51,51,50,54,57,51,50,51,52,51,52,55,60,65,66,59,60,54,53,55,53,58,58,58,56,55,56,54,60,60,60,64,62,59,59,60,60,59,59,60,59,62,61,58,59,59,58,58,59,59,60,61,58,58,58,59,59,59,60,59,62,57,59,59,57,59,58,58,58,61,62,58,57,57,59,58,57,58,59,56,57,56,57,58,58,56,57,57,53,46,48,48,48,48,48,48,52,50,50,46,47,48,48,48,47,49,51,52,46,47,47,47,47,46,47,49,50,52,44,50,47,48,46,47,48,55,48,48,44,46,47,47,44,46,49,51,43,45,44,43,45,45,46,48,49,49,45,44,51,50,47,49,49,54,49,51,47,48,49,51,48,48,47,56,47,48,48,47,47,47,47,51,51,51,45,48,47,47,45,45,45,51,51,46,46,46,46,46,45,46,49,49,49,44,46,44,46,46,45,45,49,46,44,46,45,44,43,43,43,44,45,40,41,42,41,40,42,41,41,44,44,37,42,38,39,38,38,38,41,40,39,36,38,37,37,34,37,36,39,34,36,35,34,36,36,33,37,34,37,32,33,33,33,33,31,31,40,32,34,29,31,38,38,35,34,31,36,28,39,40,37,38,38,38,39,38,40,36,37,36,36,34,37,35,38,39,36,34,36,35,35,34,35,35,36,34,34,34,34,33,33,33,37,33,35,34,34,33,32,31,31,32,36,34,33,30,29,30,29,28,30,29,32,28,29,28,28,29,27,25,26,28,28,25,24,25,24,25,23,24,27,26,25,24,25,24,23,24,24,23,28,24,23,24,22,23,23,24,24,24,26,22,23,23,22,23,23,26,26,26,25,24,25,23,24,21,23,23,27,21,24,23,23,23,23,23,24,23,25,18,21,20,19,19,20,20,24,23,22,18,19,19,20,19,22,20,23,24,19,19,19,19,19,18,19,20,26,18,19,20,19,20,19,21,24,21,23,18,19,21,19,21,20,19,24,23,18,19,19,19,19,19,19,19,24,18,20,18,23,23,25,24,27,27,27,22,24,24,23,22,22,24,25,26,22,24,22,22,22,23,23,24,24,26,21,23,21,21,22,21,24,23,27,21,23,21,21,21,21,22,25,25,23,19,22,21,19,21,20,21,24,20,20,20,19,20,20,19,23,23,26,19,21,20,20,21,21,21,25,24,22,20,21,21,21,18,18,20,20,22,17,18,17,17,17,17,17,21,19,21,15,17,16,16,19,17,19,22,18,16,17,19,18,19,18,17,20,22,15,17,16,16,17,17,17,20,20,18,25,25,24,24,24,23,27,27,25,25,25,24,23,23,25,25,25,24,23,25,23,24,23,23,24,24,25,23,23,25,22,26,23,24,27,27,27,24,23,24,23,23,21,23,28,29,26,25,23,25,25,22,23,24,27,23,24,23,22,23,20,19,21,19,23,16,18,19,18,18,18,19,23,21,22,18,19,19,19,19,20,18,23,23,19,21,17,19,19,20,23,23,24,19,21,19,20,20,19,21,24,25,21,21,21,23,24,21,20,22,25,25,20,22,22,24,23,24,25,25,31,27,29,28,28,28,29,28,32,33,32,27,30,29,30,29,31,29,33,33,28,29,28,29,33,32,31,31,31,30,30,30,28,29,28,29,32,33,30,28,30,29,29,28,29,32,35,35,29,32,29,29,30,29,30,30,32,33,27,30,30,30,30,32,33,33,35,29,32,30,32,31,31,32,35,36,33,31,31,32,32,33,33,36,36,36,31,32,33,33,34,33,33,39,34,34,33,36,34,35,33,35,37,39,35,37,37,35,35,37,38,40,37,41,35,36,37,37,37,38,40,44,41,41,41,41,41,41,41,41,41,45,41,42,42,41,41,43,44,43,45,45,40,42,42,43,41,43,45,45,44,43,42,43,43,43,44,43,43,48,44,45,43,44,46,46,46,47,48,46,44,46,46,44,45,46,45,49,46,45,40,38,39,38,39,37,40,43,37,38,38,36,38,38,39,42,42,40,40,39,39,40,39,38,39,42,44,37,40,39,39,40,39,42,39,45,44,39,41,39,38,41,39,40,43,45,43,40,41,42,41,41,42,48,46,40,41,41,40,43,51,51,52,55,54,51,52,51,53,52,52,52,55,53,52,53,52,52,52,53,53,52,55,51,52,53,52,53,53,53,54,55,55,52,56,55,54,53,55,55,56,56,54,54,60,61,61,59,55,55,58,54,56,55,60,62,61,59,59,59,48,47,48,48,47,47,47,47,54,55,51,50,49,47,47,48,48,49,52,51,46,47,47,47,52,48,48,51,50,51,46,48,48,47,47,47,46,51,45,49,47,47,47,47,50,51,51,49,43,47,46,48,43,46,47,51,51,44,46,47,46,47,47,45,48,49,46,47,46,46,45,45,46,48,51,46,45,46,46,48,45,45,45,48,50,44,46,46,45,47,46,46,49,49,50,44,46,46,45,47,46,46,51,47,46,47,47,46,47,45,45,49,49,44,46,46,45,51,53,53,49,49,50,43,44,44,44,43,44,44,47,44,46,43,45,44,43,43,45,46,46,43,44,45,44,46,46,46,47,49,49,43,45,45,45,44,45,46,49,66,83,83,28,33,40,45,46,44,51,48,46,46,46,47,46,46,47,48,45,45,46,45,45,44,43,45,48,48,42,43,43,44,44,43,45,45,47,45,42,46,44,43,42,43,43,48,42,45,40,45,42,42,41,42,42,46,40,41,42,41,43,42,41,44,47,46,42,42,40,40,39,40,41,45,43,39,40,41,40,40,46,47,46,49,46,46,46,45,46,46,46,48,48,50,46,47,45,47,44,46,46,49,49,48,44,46,45,47,46,46,46,49,49,44,45,45,45,45,45,48,46,49,43,47,52,47,48,44,45,50,50,44,47,47,46,47,47,46,46,51,54,49,52,53,51,52,52,52,54,54,53,52,51,51,52,51,51,52,53,49,49,49,49,53,52,51,54,53,54,48,51,51,51,50,51,51,54,54,51,51,51,52,52,53,60,61,63,56,60,55,51,53,55,52,62,60,57,52,53,54,56,55,57,56,60,59,55,56,56,56,57,56,56,56,60,59,56,58,56,56,58,57,57,59,59,57,56,57,58,57,56,58,58,60,57,59,57,57,58,57,56,57,58,60,55,57,58,57,56,56,57,60,59,56,57,57,57,57,57,58,56,59,59,57,58,57,58,58,58,57,60,59,59,56,58,57,58,56,58,58,60,58,57,58,59,60,58,58,59,60,61,56,58,58,57,58,58,57,60,60,59,57,57,58,65,66,66,64,62,61,59,59,59,59,62,60,63,61,62,58,60,60,60,59,60,60,65,63,60,61,59,60,60,59,59,60,63,61,58,59,59,60,59,58,59,60,60,60,57,60,59,58,56,58,58,61,56,57,57,57,56,58,57,58,57,61,57,57,57,56,56,54,56,59,60,57,55,57,57,55,52,54,54,57,57,53,53,54,53,55,55,54,56,57,56,52,54,55,54,54,54,56,55,57,53,55,55,55,55,53,53,53,57,52,53,54,52,54,54,54,55,55,56,52,53,53,53,54,53,52,55,53,53,54,54,54,54,52,53,53,49,44,45,46,44,45,46,45,50,49,47,46,45,45,46,44,43,44,49,49,44,46,42,45,45,45,44,45,50,48,41,45,44,44,44,44,42,46,46,43,42,42,46,43,43,42,46,45,43,42,41,40,42,41,41,44,47,44,42,43,46,44,44,45,44,47,47,43,44,45,45,44,44,46,44,47,43,44,44,43,43,44,43,46,45,46,42,44,43,44,43,43,42,47,41,44,43,43,42,43,42,41,41,44,42,41,45,40,43,42,41,43,43,51,46,46,43,44,43,41,29,33,32,31,27,29,28,28,29,27,27,31,25,27,27,28,26,26,27,29,31,29,26,25,28,26,25,24,26,30,32,27,25,29,24,25,26,25,25,30,23,26,24,24,24,25,30,25,28,28,24,24,25,24,23,28,25,29,27,26,30,30,31,30,28,30,29,32,33,30,29,30,29,30,29,32,36,32,28,29,29,28,30,27,28,31,33,29,28,28,28,28,30,28,28,30,33,26,30,27,27,28,28,29,29,31,35,27,28,28,28,26,28,30,32,27,27,27,28,26,25,24,24,27,28,23,24,24,25,24,25,25,26,27,28,22,23,24,25,23,25,24,29,25,21,23,23,23,22,20,22,24,25,21,22,20,20,23,21,20,22,24,18,21,23,20,23,21,21,22,22,22,17,19,19,19,17,17,19,21,25,21,19,20,20,20,20,21,21,22,20,20,20,20,20,20,21,22,23,25,19,20,20,19,19,19,19,24,23,20,20,20,19,20,20,21,19,23,18,20,21,19,20,19,22,21,27,21,19,19,20,22,20,18,20,23,22,20,21,20,20,19,19,19,20,24,18,22,19,20,20,19,19,22,21,24,18,19,20,21,21,21,21,24,25,21,19,20,20,20,19,18,19,23,21,18,20,20,19,19,18,19,18,21,20,18,20,17,17,17,17,21,20,18,16,17,18,17,16,18,23,27,25,22,23,25,23,23,23,24,25,26,23,23,24,23,23,23,24,28,27,25,25,25,24,24,23,29,25,28,25,23,24,23,25,23,24,24,27,28,25,24,24,24,24,26,27,27,27,27,25,27,25,27,24,26,27,30,29,27,17,17,18,17,17,18,19,22,17,18,18,17,18,18,18,19,21,20,19,18,19,20,18,20,21,22,23,18,18,20,19,19,20,20,19,24,18,19,20,19,20,21,21,22,22,25,23,20,21,22,19,22,21,26,25,21,21,22,22,21,24,24,23,26,26,24,25,22,24,25,24,29,26,27,25,26,26,26,26,25,25,28,30,30,29,31,29,27,25,27,27,31,32,26,28,27,27,27,28,29,29,34,28,29,30,31,33,29,29,33,33,30,29,31,33,30,29,30,32,34,38,30,31,31,31,32,32,31,34,34,35,30,32,32,32,30,32,32,35,33,30,32,31,33,33,31,32,41,36,28,32,29,30,32,30,31,34,36,34,30,31,31,31,32,32,31,40,32,31,31,32,32,31,33,34,33,34,31,32,32,40,41,42,42,44,44,43,38,41,41,41,40,42,42,44,40,41,39,40,40,40,40,43,41,46,39,41,41,43,43,42,40,44,45,44,38,40,41,40,40,41,40,44,41,40,40,43,40,41,39,42,38,43,40,39,39,39,39,39,40,42,42,39,40,43,40,39,36,39,39,43,43,40,38,40,38,39,39,38,39,43,42,40,41,40,40,39,38,39,45,43,42,37,39,39,40,39,40,40,42,40,41,40,39,40,41,45,43,42,46,39,40,41,42,41,43,41,46,42,41,45,45,46,45,44,45,49,47,44,47,46,44,44,45,45,46,49,47,43,45,44,44,43,43,44,48,47,44,41,43,45,45,44,42,42,44,43,43,42,40,43,42,42,45,53,54,55,53,51,45,42,41,45,49,54,48,46,43,44,44,46,45,45,48,49,42,45,42,44,48,48,47,47,46,45,43,44,44,43,43,44,50,48,44,45,48,42,46,43,43,46,49,47,44,45,43,43,40,40,41,45,42,42,41,42,41,44,43,41,42,45,40,41,46,40,43,42,41,44,45,45,42,45,45,42,44,42,44,48,47,43,42,43,45,43,42,42,43,47,47,40,43,41,43,42,42,42,46,46,44,43,42,43,42,43,45,44,50,43,43,44,43,43,43,42,42,51,49,42,42,42,42,42,42,43,45,45,43,44,43,46,46,45,47,46,49,45,46,46,46,46,46,46,47,48,50,44,46,47,46,46,46,47,50,51,46,46,47,46,47,48,47,47,51,45,48,47,49,47,47,47,50,51,50,46,48,50,48,49,47,47,51,51,48,49,49,48,49,49,48,43,45,47,42,43,41,42,42,43,43,46,46,47,41,46,48,43,41,43,43,48,43,42,43,44,43,44,44,45,47,45,42,43,43,44,43,44,43,49,46,47,42,46,44,44,44,47,44,50,44,45,44,43,44,45,45,44,47,48,45,43,40,39,40,41,40,43,45,41,40,41,42,41,40,40,40,45,44,40,41,40,40,42,41,46,43,47,41,41,42,42,42,42,41,47,46,43,40,43,43,46,41,43,47,48,48,47,46,44,44,44,45,44,46,48,48,42,45,48,45,52,52,52,55,53,53,50,52,51,52,51,52,51,55,52,53,52,51,52,52,51,55,53,54,49,52,54,54,50,52,52,56,51,51,52,51,51,52,51,50,54,56,49,54,59,59,63,60,60,60,57,57,53,54,57,58,54,53,53,59,58,57,57,56,56,58,57,57,57,60,62,60,61,60,59,59,60,58,60,59,57,58,59,59,59,59,59,59,61,59,59,60,60,59,59,58,60,61,59,57,60,59,58,59,58,59,65,58,58,59,57,58,59,59,60,59,62,57,59,58,57,57,57,58,59,62,59,57,58,58,59,57,58,57,60,62,56,62,57,56,58,59,58,63,61,61,58,60,58,58,58,59,59,62,57,58,59,60,59,59,60,61,58,63,65,67,66,64,61,58,59,61,62,59,59,60,60,60,59,60,60,64,65,59,63,60,61,61,62,62,63,63,63,60,61,60,60,58,62,61,63,59,60,60,59,60,60,60,61,62,62,58,60,62,64,58,60,59,63,59,61,57,60,59,59,59,62,60,61,56,59,59,58,58,59,58,60,59,59,56,51,50,49,48,48,49,53,54,49,48,48,48,49,48,48,48,51,52,45,48,46,46,48,47,48,51,55,49,48,46,48,50,45,47,47,50,45,47,47,46,46,45,47,47,45,50,48,48,48,47,46,45,46,51,48,48,43,46,45,45,46,48,47,52,47,48,48,46,47,48,47,49,48,50,44,47,47,46,45,47,47,50,49,46,44,46,45,46,44,45,47,48,49,43,45,45,43,45,44,45,48,49,47,44,45,44,45,45,45,51,48,43,43,44,44,44,44,44,43,47,50,47,49,48,47,48,48,48,49,50,50,47,48,47,47,47,46,47,48,47,46,47,46,46,46,46,45,49,48,45,45,46,46,45,45,46,48,48,48,44,45,45,45,43,44,44,48,46,45,45,44,45};
    @Test
    public void testServiceEntityBW(){
        ResourcePredictor rp = new ResourcePredictor("http://192.168.235.136:2019/predict");
        ArrayList<Double> arrayList = new ArrayList<>();
        for(int i = 0; i< 10; i++) {
            arrayList.add(Double.valueOf(testData[i]));
        }
        ArrayList<Double> res = rp.predict2(arrayList, 1);
        Log.printLine(res);
    }
}