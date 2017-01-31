<form action="preset" method="POST">
    <table class="table table-bordered table-condensed">
        <tbody>
        <tr>
            <td>ID</td>
            <td><input type="text" name="ID" class="form-control" value=${preset.deviceID}>
        </tr>
        <tr>
            <td>Точка доступа сим 0</td>
            <td><input type="text" name="sim0Apn" class="form-control" value=${preset.sim0Apn}></td>
        </tr>
        <tr>
            <td>Пользователь сим 0</td>
            <td><input type="text" name="sim0ApnUser" class="form-control" value=${preset.sim0ApnUser}></td>
        </tr>
        <tr>
            <td>Пароль сим 0</td>
            <td><input type="text" name="sim0ApnPassword" class="form-control" value=${preset.sim0ApnPassword}></td>
        </tr>
        <tr>
            <td>Точка доступа сим 1</td>
            <td><input type="text" name="sim1Apn" class="form-control" value=${preset.sim1Apn}></td>
        </tr>
        <tr>
            <td>Пользователь сим 1</td>
            <td><input type="text" name="sim1ApnUser" class="form-control" value=${preset.sim1ApnUser}></td>
        </tr>
        <tr>
            <td>Пароль сим 1</td>
            <td><input type="text" name="sim1ApnPassword" class="form-control" value=${preset.sim1ApnPassword}></td>
        </tr>
        <tr>
            <td>Путь к сервера</td>
            <td><input type="text" name="serverURL" class="form-control" value=${preset.serverURL}></td>
        </tr>
        <tr>
            <td>Порт сервера</td>
            <td><input type="text" name="serverPort" class="form-control" value=${preset.serverPort}></td>
        </tr>
        <tr>
            <td>Сим 0 MCC/MNC</td>
            <td><input type="text" name="sim0MCC" class="form-control" value=${preset.sim0MCCMNC.MCC}></td>
            <td><input type="text" name="sim0MNC" class="form-control" value=${preset.sim0MCCMNC.MNC}></td>
        </tr>
        <tr>
            <td></td>
            <td>Сим 1 MCC/MNC</td>
        </tr>
        <tr>
            <td>1</td>
            <td><input type="text" name="sim1MCC0" class="form-control" value=${preset.sim1MCCMNC[0].MCC}></td>
            <td><input type="text" name="sim1MNC0" class="form-control" value=${preset.sim1MCCMNC[0].MNC}></td>
        </tr>
        <tr>
            <td>2</td>
            <td><input type="text" name="sim1MCC1" class="form-control" value=${preset.sim1MCCMNC[1].MCC}></td>
            <td><input type="text" name="sim1MNC1" class="form-control" value=${preset.sim1MCCMNC[1].MNC}></td>
        </tr>
        <tr>
            <td>3</td>
            <td><input type="text" name="sim1MCC2" class="form-control" value=${preset.sim1MCCMNC[2].MCC}></td>
            <td><input type="text" name="sim1MNC2" class="form-control" value=${preset.sim1MCCMNC[2].MNC}></td>
        </tr>
        <tr>
            <td>4</td>
            <td><input type="text" name="sim1MCC3" class="form-control" value=${preset.sim1MCCMNC[3].MCC}></td>
            <td><input type="text" name="sim1MNC3" class="form-control" value=${preset.sim1MCCMNC[3].MNC}></td>
        </tr>
        <tr>
            <td>5</td>
            <td><input type="text" name="sim1MCC4" class="form-control" value=${preset.sim1MCCMNC[4].MCC}></td>
            <td><input type="text" name="sim1MNC4" class="form-control" value=${preset.sim1MCCMNC[4].MNC}></td>
        </tr>
        <tr>
            <td>6</td>
            <td><input type="text" name="sim1MCC5" class="form-control" value=${preset.sim1MCCMNC[5].MCC}></td>
            <td><input type="text" name="sim1MNC5" class="form-control" value=${preset.sim1MCCMNC[5].MNC}></td>
        </tr>
        <tr>
            <td>7</td>
            <td><input type="text" name="sim1MCC6" class="form-control" value=${preset.sim1MCCMNC[6].MCC}></td>
            <td><input type="text" name="sim1MNC6" class="form-control" value=${preset.sim1MCCMNC[6].MNC}></td>
        </tr>
        <tr>
            <td>8</td>
            <td><input type="text" name="sim1MCC7" class="form-control" value=${preset.sim1MCCMNC[7].MCC}></td>
            <td><input type="text" name="sim1MNC7" class="form-control" value=${preset.sim1MCCMNC[7].MNC}></td>
        </tr>
        <tr>
            <td>9</td>
            <td><input type="text" name="sim1MCC8" class="form-control" value=${preset.sim1MCCMNC[8].MCC}></td>
            <td><input type="text" name="sim1MNC8" class="form-control" value=${preset.sim1MCCMNC[8].MNC}></td>
        </tr>
        <tr>
            <td>10</td>
            <td><input type="text" name="sim1MCC9" class="form-control" value=${preset.sim1MCCMNC[9].MCC}></td>
            <td><input type="text" name="sim1MNC9" class="form-control" value=${preset.sim1MCCMNC[9].MNC}></td>
        </tr>
        <tr>
            <td>11</td>
            <td><input type="text" name="sim1MCC10" class="form-control" value=${preset.sim1MCCMNC[10].MCC}></td>
            <td><input type="text" name="sim1MNC10" class="form-control" value=${preset.sim1MCCMNC[10].MNC}></td>
        </tr>
        <tr>
            <td>12</td>
            <td><input type="text" name="sim1MCC11" class="form-control" value=${preset.sim1MCCMNC[11].MCC}></td>
            <td><input type="text" name="sim1MNC11" class="form-control" value=${preset.sim1MCCMNC[11].MNC}></td>
        </tr>
        <tr>
            <td>13</td>
            <td><input type="text" name="sim1MCC12" class="form-control" value=${preset.sim1MCCMNC[12].MCC}></td>
            <td><input type="text" name="sim1MNC12" class="form-control" value=${preset.sim1MCCMNC[12].MNC}></td>
        </tr>
        <tr>
            <td>14</td>
            <td><input type="text" name="sim1MCC13" class="form-control" value=${preset.sim1MCCMNC[13].MCC}></td>
            <td><input type="text" name="sim1MNC13" class="form-control" value=${preset.sim1MCCMNC[13].MNC}></td>
        </tr>
        <tr>
            <td>15</td>
            <td><input type="text" name="sim1MCC14" class="form-control" value=${preset.sim1MCCMNC[14].MCC}></td>
            <td><input type="text" name="sim1MNC14" class="form-control" value=${preset.sim1MCCMNC[14].MNC}></td>
        </tr>
        <tr>
            <td>16</td>
            <td><input type="text" name="sim1MCC15" class="form-control" value=${preset.sim1MCCMNC[15].MCC}></td>
            <td><input type="text" name="sim1MNC15" class="form-control" value=${preset.sim1MCCMNC[15].MNC}></td>
        </tr>
        <tr>
            <td>17</td>
            <td><input type="text" name="sim1MCC16" class="form-control" value=${preset.sim1MCCMNC[16].MCC}></td>
            <td><input type="text" name="sim1MNC16" class="form-control" value=${preset.sim1MCCMNC[16].MNC}></td>
        </tr>
        <tr>
            <td>18</td>
            <td><input type="text" name="sim1MCC17" class="form-control" value=${preset.sim1MCCMNC[17].MCC}></td>
            <td><input type="text" name="sim1MNC17" class="form-control" value=${preset.sim1MCCMNC[17].MNC}></td>
        </tr>
        <tr>
            <td>19</td>
            <td><input type="text" name="sim1MCC18" class="form-control" value=${preset.sim1MCCMNC[18].MCC}></td>
            <td><input type="text" name="sim1MNC18" class="form-control" value=${preset.sim1MCCMNC[18].MNC}></td>
        </tr>
        <tr>
            <td>20</td>
            <td><input type="text" name="sim1MCC19" class="form-control" value=${preset.sim1MCCMNC[19].MCC}></td>
            <td><input type="text" name="sim1MNC19" class="form-control" value=${preset.sim1MCCMNC[19].MNC}></td>
        </tr>
        <tr>
            <td>21</td>
            <td><input type="text" name="sim1MCC20" class="form-control" value=${preset.sim1MCCMNC[20].MCC}></td>
            <td><input type="text" name="sim1MNC20" class="form-control" value=${preset.sim1MCCMNC[20].MNC}></td>
        </tr>
        <tr>
            <td>22</td>
            <td><input type="text" name="sim1MCC21" class="form-control" value=${preset.sim1MCCMNC[21].MCC}></td>
            <td><input type="text" name="sim1MNC21" class="form-control" value=${preset.sim1MCCMNC[21].MNC}></td>
        </tr>
        <tr>
            <td>23</td>
            <td><input type="text" name="sim1MCC22" class="form-control" value=${preset.sim1MCCMNC[22].MCC}></td>
            <td><input type="text" name="sim1MNC22" class="form-control" value=${preset.sim1MCCMNC[22].MNC}></td>
        </tr>
        <tr>
            <td>24</td>
            <td><input type="text" name="sim1MCC23" class="form-control" value=${preset.sim1MCCMNC[23].MCC}></td>
            <td><input type="text" name="sim1MNC23" class="form-control" value=${preset.sim1MCCMNC[23].MNC}></td>
        </tr>
        <tr>
            <td>25</td>
            <td><input type="text" name="sim1MCC24" class="form-control" value=${preset.sim1MCCMNC[24].MCC}></td>
            <td><input type="text" name="sim1MNC24" class="form-control" value=${preset.sim1MCCMNC[24].MNC}></td>
        </tr>
        <tr>
            <td>26</td>
            <td><input type="text" name="sim1MCC25" class="form-control" value=${preset.sim1MCCMNC[25].MCC}></td>
            <td><input type="text" name="sim1MNC25" class="form-control" value=${preset.sim1MCCMNC[25].MNC}></td>
        </tr>
        <tr>
            <td>27</td>
            <td><input type="text" name="sim1MCC26" class="form-control" value=${preset.sim1MCCMNC[26].MCC}></td>
            <td><input type="text" name="sim1MNC26" class="form-control" value=${preset.sim1MCCMNC[26].MNC}></td>
        </tr>
        <tr>
            <td>28</td>
            <td><input type="text" name="sim1MCC27" class="form-control" value=${preset.sim1MCCMNC[27].MCC}></td>
            <td><input type="text" name="sim1MNC27" class="form-control" value=${preset.sim1MCCMNC[27].MNC}></td>
        </tr>
        <tr>
            <td>29</td>
            <td><input type="text" name="sim1MCC28" class="form-control" value=${preset.sim1MCCMNC[28].MCC}></td>
            <td><input type="text" name="sim1MNC28" class="form-control" value=${preset.sim1MCCMNC[28].MNC}></td>
        </tr>
        <tr>
            <td>30</td>
            <td><input type="text" name="sim1MCC29" class="form-control" value=${preset.sim1MCCMNC[29].MCC}></td>
            <td><input type="text" name="sim1MNC29" class="form-control" value=${preset.sim1MCCMNC[29].MNC}></td>
        </tr>
        <tr>
            <td>31</td>
            <td><input type="text" name="sim1MCC30" class="form-control" value=${preset.sim1MCCMNC[30].MCC}></td>
            <td><input type="text" name="sim1MNC30" class="form-control" value=${preset.sim1MCCMNC[30].MNC}></td>
        </tr>
        <tr>
            <td>32</td>
            <td><input type="text" name="sim1MCC31" class="form-control" value=${preset.sim1MCCMNC[31].MCC}></td>
            <td><input type="text" name="sim1MNC31" class="form-control" value=${preset.sim1MCCMNC[31].MNC}></td>
        </tr>
        <tr>
            <td>33</td>
            <td><input type="text" name="sim1MCC32" class="form-control" value=${preset.sim1MCCMNC[32].MCC}></td>
            <td><input type="text" name="sim1MNC32" class="form-control" value=${preset.sim1MCCMNC[32].MNC}></td>
        </tr>
        <tr>
            <td>34</td>
            <td><input type="text" name="sim1MCC33" class="form-control" value=${preset.sim1MCCMNC[33].MCC}></td>
            <td><input type="text" name="sim1MNC33" class="form-control" value=${preset.sim1MCCMNC[33].MNC}></td>
        </tr>
        <tr>
            <td>35</td>
            <td><input type="text" name="sim1MCC34" class="form-control" value=${preset.sim1MCCMNC[34].MCC}></td>
            <td><input type="text" name="sim1MNC34" class="form-control" value=${preset.sim1MCCMNC[34].MNC}></td>
        </tr>
        <tr>
            <td>36</td>
            <td><input type="text" name="sim1MCC35" class="form-control" value=${preset.sim1MCCMNC[35].MCC}></td>
            <td><input type="text" name="sim1MNC35" class="form-control" value=${preset.sim1MCCMNC[35].MNC}></td>
        </tr>
        <tr>
            <td>37</td>
            <td><input type="text" name="sim1MCC36" class="form-control" value=${preset.sim1MCCMNC[36].MCC}></td>
            <td><input type="text" name="sim1MNC36" class="form-control" value=${preset.sim1MCCMNC[36].MNC}></td>
        </tr>
        <tr>
            <td>38</td>
            <td><input type="text" name="sim1MCC37" class="form-control" value=${preset.sim1MCCMNC[37].MCC}></td>
            <td><input type="text" name="sim1MNC37" class="form-control" value=${preset.sim1MCCMNC[37].MNC}></td>
        </tr>
        <tr>
            <td>39</td>
            <td><input type="text" name="sim1MCC38" class="form-control" value=${preset.sim1MCCMNC[38].MCC}></td>
            <td><input type="text" name="sim1MNC38" class="form-control" value=${preset.sim1MCCMNC[38].MNC}></td>
        </tr>
        <tr>
            <td>40</td>
            <td><input type="text" name="sim1MCC39" class="form-control" value=${preset.sim1MCCMNC[39].MCC}></td>
            <td><input type="text" name="sim1MNC39" class="form-control" value=${preset.sim1MCCMNC[39].MNC}></td>
        </tr>
        <tr>
            <td>41</td>
            <td><input type="text" name="sim1MCC40" class="form-control" value=${preset.sim1MCCMNC[40].MCC}></td>
            <td><input type="text" name="sim1MNC40" class="form-control" value=${preset.sim1MCCMNC[40].MNC}></td>
        </tr>
        <tr>
            <td>42</td>
            <td><input type="text" name="sim1MCC41" class="form-control" value=${preset.sim1MCCMNC[41].MCC}></td>
            <td><input type="text" name="sim1MNC41" class="form-control" value=${preset.sim1MCCMNC[41].MNC}></td>
        </tr>
        <tr>
            <td>43</td>
            <td><input type="text" name="sim1MCC42" class="form-control" value=${preset.sim1MCCMNC[42].MCC}></td>
            <td><input type="text" name="sim1MNC42" class="form-control" value=${preset.sim1MCCMNC[42].MNC}></td>
        </tr>
        <tr>
            <td>44</td>
            <td><input type="text" name="sim1MCC43" class="form-control" value=${preset.sim1MCCMNC[43].MCC}></td>
            <td><input type="text" name="sim1MNC43" class="form-control" value=${preset.sim1MCCMNC[43].MNC}></td>
        </tr>
        <tr>
            <td>45</td>
            <td><input type="text" name="sim1MCC44" class="form-control" value=${preset.sim1MCCMNC[44].MCC}></td>
            <td><input type="text" name="sim1MNC44" class="form-control" value=${preset.sim1MCCMNC[44].MNC}></td>
        </tr>
        <tr>
            <td>46</td>
            <td><input type="text" name="sim1MCC45" class="form-control" value=${preset.sim1MCCMNC[45].MCC}></td>
            <td><input type="text" name="sim1MNC45" class="form-control" value=${preset.sim1MCCMNC[45].MNC}></td>
        </tr>
        <tr>
            <td>47</td>
            <td><input type="text" name="sim1MCC46" class="form-control" value=${preset.sim1MCCMNC[46].MCC}></td>
            <td><input type="text" name="sim1MNC46" class="form-control" value=${preset.sim1MCCMNC[46].MNC}></td>
        </tr>
        <tr>
            <td>48</td>
            <td><input type="text" name="sim1MCC47" class="form-control" value=${preset.sim1MCCMNC[47].MCC}></td>
            <td><input type="text" name="sim1MNC47" class="form-control" value=${preset.sim1MCCMNC[47].MNC}></td>
        </tr>
        <tr>
            <td>49</td>
            <td><input type="text" name="sim1MCC48" class="form-control" value=${preset.sim1MCCMNC[48].MCC}></td>
            <td><input type="text" name="sim1MNC48" class="form-control" value=${preset.sim1MCCMNC[48].MNC}></td>
        </tr>
        <tr>
            <td>50</td>
            <td><input type="text" name="sim1MCC49" class="form-control" value=${preset.sim1MCCMNC[49].MCC}></td>
            <td><input type="text" name="sim1MNC49" class="form-control" value=${preset.sim1MCCMNC[49].MNC}></td>
        </tr>
        <tr>
            <td>51</td>
            <td><input type="text" name="sim1MCC50" class="form-control" value=${preset.sim1MCCMNC[50].MCC}></td>
            <td><input type="text" name="sim1MNC50" class="form-control" value=${preset.sim1MCCMNC[50].MNC}></td>
        </tr>
        <tr>
            <td>52</td>
            <td><input type="text" name="sim1MCC51" class="form-control" value=${preset.sim1MCCMNC[51].MCC}></td>
            <td><input type="text" name="sim1MNC51" class="form-control" value=${preset.sim1MCCMNC[51].MNC}></td>
        </tr>
        <tr>
            <td>53</td>
            <td><input type="text" name="sim1MCC52" class="form-control" value=${preset.sim1MCCMNC[52].MCC}></td>
            <td><input type="text" name="sim1MNC52" class="form-control" value=${preset.sim1MCCMNC[52].MNC}></td>
        </tr>
        <tr>
            <td>54</td>
            <td><input type="text" name="sim1MCC53" class="form-control" value=${preset.sim1MCCMNC[53].MCC}></td>
            <td><input type="text" name="sim1MNC53" class="form-control" value=${preset.sim1MCCMNC[53].MNC}></td>
        </tr>
        <tr>
            <td>55</td>
            <td><input type="text" name="sim1MCC54" class="form-control" value=${preset.sim1MCCMNC[54].MCC}></td>
            <td><input type="text" name="sim1MNC54" class="form-control" value=${preset.sim1MCCMNC[54].MNC}></td>
        </tr>
        <tr>
            <td>56</td>
            <td><input type="text" name="sim1MCC55" class="form-control" value=${preset.sim1MCCMNC[55].MCC}></td>
            <td><input type="text" name="sim1MNC55" class="form-control" value=${preset.sim1MCCMNC[55].MNC}></td>
        </tr>
        <tr>
            <td>57</td>
            <td><input type="text" name="sim1MCC56" class="form-control" value=${preset.sim1MCCMNC[56].MCC}></td>
            <td><input type="text" name="sim1MNC56" class="form-control" value=${preset.sim1MCCMNC[56].MNC}></td>
        </tr>
        <tr>
            <td>58</td>
            <td><input type="text" name="sim1MCC57" class="form-control" value=${preset.sim1MCCMNC[57].MCC}></td>
            <td><input type="text" name="sim1MNC57" class="form-control" value=${preset.sim1MCCMNC[57].MNC}></td>
        </tr>
        <tr>
            <td>59</td>
            <td><input type="text" name="sim1MCC58" class="form-control" value=${preset.sim1MCCMNC[58].MCC}></td>
            <td><input type="text" name="sim1MNC58" class="form-control" value=${preset.sim1MCCMNC[58].MNC}></td>
        </tr>
        <tr>
            <td>60</td>
            <td><input type="text" name="sim1MCC59" class="form-control" value=${preset.sim1MCCMNC[59].MCC}></td>
            <td><input type="text" name="sim1MNC59" class="form-control" value=${preset.sim1MCCMNC[59].MNC}></td>
        </tr>
        <tr>
            <td>61</td>
            <td><input type="text" name="sim1MCC60" class="form-control" value=${preset.sim1MCCMNC[60].MCC}></td>
            <td><input type="text" name="sim1MNC60" class="form-control" value=${preset.sim1MCCMNC[60].MNC}></td>
        </tr>
        <tr>
            <td>62</td>
            <td><input type="text" name="sim1MCC61" class="form-control" value=${preset.sim1MCCMNC[61].MCC}></td>
            <td><input type="text" name="sim1MNC61" class="form-control" value=${preset.sim1MCCMNC[61].MNC}></td>
        </tr>
        <tr>
            <td>63</td>
            <td><input type="text" name="sim1MCC62" class="form-control" value=${preset.sim1MCCMNC[62].MCC}></td>
            <td><input type="text" name="sim1MNC62" class="form-control" value=${preset.sim1MCCMNC[62].MNC}></td>
        </tr>
        <tr>
            <td>64</td>
            <td><input type="text" name="sim1MCC63" class="form-control" value=${preset.sim1MCCMNC[63].MCC}></td>
            <td><input type="text" name="sim1MNC63" class="form-control" value=${preset.sim1MCCMNC[63].MNC}></td>
        </tr>
        <tr>
            <td>65</td>
            <td><input type="text" name="sim1MCC64" class="form-control" value=${preset.sim1MCCMNC[64].MCC}></td>
            <td><input type="text" name="sim1MNC64" class="form-control" value=${preset.sim1MCCMNC[64].MNC}></td>
        </tr>
        <tr>
            <td>66</td>
            <td><input type="text" name="sim1MCC65" class="form-control" value=${preset.sim1MCCMNC[65].MCC}></td>
            <td><input type="text" name="sim1MNC65" class="form-control" value=${preset.sim1MCCMNC[65].MNC}></td>
        </tr>
        <tr>
            <td>67</td>
            <td><input type="text" name="sim1MCC66" class="form-control" value=${preset.sim1MCCMNC[66].MCC}></td>
            <td><input type="text" name="sim1MNC66" class="form-control" value=${preset.sim1MCCMNC[66].MNC}></td>
        </tr>
        <tr>
            <td>68</td>
            <td><input type="text" name="sim1MCC67" class="form-control" value=${preset.sim1MCCMNC[67].MCC}></td>
            <td><input type="text" name="sim1MNC67" class="form-control" value=${preset.sim1MCCMNC[67].MNC}></td>
        </tr>
        <tr>
            <td>69</td>
            <td><input type="text" name="sim1MCC68" class="form-control" value=${preset.sim1MCCMNC[68].MCC}></td>
            <td><input type="text" name="sim1MNC68" class="form-control" value=${preset.sim1MCCMNC[68].MNC}></td>
        </tr>
        <tr>
            <td>70</td>
            <td><input type="text" name="sim1MCC69" class="form-control" value=${preset.sim1MCCMNC[69].MCC}></td>
            <td><input type="text" name="sim1MNC69" class="form-control" value=${preset.sim1MCCMNC[69].MNC}></td>
        </tr>
        </tbody>
    </table>
    <div class="form-group">
        <input class="form-control" class="btn btn-default" type="submit"  name="save" id="send" value="Сохранить" >
    </div>
</form>
