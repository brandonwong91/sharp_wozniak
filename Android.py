
# coding: utf-8

# In[12]:


import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler
from sklearn.externals import joblib
from sklearn.preprocessing import StandardScaler


# In[14]:


class Moon_Light:
    def run_model():
        df3= pd.read_csv('final_before_scale.csv')

        df3 = df3[['acne','backache','bloating','cramp','diarrhea','dizzy','headache','mood','nausea','sore']]

        scaler = StandardScaler()
        scaler.fit(df3)
        df3 = scaler.fit_transform(df3)

        filename = 'finalized_model.sav'
        loaded_model = joblib.load(filename)

        input_array = []
        cycle_length_initial = int(input('Enter the average cycle length experienced    '))
        period_length_initial = int(input('Enter the days the period lasts for   '))
        day_from = int(input('Enter the Days passed from last period   '))
        out = loaded_model.predict(np.array(input_array).reshape(1, -1))
        xzy = list(out[0]) 

        symps = scaler.inverse_transform(xzy)
        symps_index = np.argsort(symps)

        data = pd.read_csv('Symptom.csv')
        list_symps = data.keys()[2:12]

        list_symps = list(list_symps)

        symps = symps.round(0)

        input_array = [cycle_length_initial,period_length_initial,day_from]
        print("The symptom may include: ")
        for i in range(3):
            print( list_symps[symps_index[i]] + " with a percentage of " + str(symps[i]))

