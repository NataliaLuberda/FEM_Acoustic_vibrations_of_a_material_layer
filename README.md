# FEM_Acoustic_vibrations_of_a_material_layer
Differential and difference equations - project 2022/2023.

<p align=”center”>
<a href=”” rel=”noopener”>
<img width=200px height=200px src=”” alt=”Project logo”></a>
</p>![Zrzut ekranu 2023-01-04 192325](https://user-images.githubusercontent.com/115657578/210623574-8dd05ac8-e703-43d0-b799-9d6700ee6a70.png)



<h3 align=”center”></h3>
MES - Wibracje akustyczne warstwy materiału
— — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — -

<p align=”center”> 
<br>
</p>

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Built Using](#built_using)
- [Authors](#authors)

## 🧐 About <a name = “about”></a>
To równanie opisuje problem związany z wibracjami akustycznymi warstwy materiału. Równanie to jest równaniem różniczkowym cząstkowym drugiego rzędu z warunkami brzegowymi na granicach przedziału [0, 2]. Można go rozwiązać przy użyciu różnych metod numerycznych, takich jak metoda elementów skończonych, która jest implementowana w podanym kodzie.

## 🏁 Getting Started <a name = “getting_started”> </a>
 Działanie kodu:
 Algorytm implementowany w tym kodzie stosuje metodę elementów skończonych do rozwiązywania równań różniczkowych cząstkowych. Klasa IterativeLegendreGaussIntegrator jest używana do wykonywania numerycznego całkowania, a metody base i basePrim definiują bazowe funkcje, które są używane. Metoda coefficients służy do znajdowania współczynników dla tych funkcji poprzez rozwiązywanie układu równań liniowych reprezentowanego przez macierze bMatrix i vectorL. Metoda getBMatrix oblicza elementy macierzy bMatrix, a metoda getLMatrix oblicza elementy macierzy vectorL. Następnie tworzony jest wykres.


## ⛏️ Built Using <a name = “built_using”></a>
Projekt został stworzony w języku programowania Java z użyciem biblioteki JavaFX

## ✍️ Authors <a name = “authors”></a>
Natalia Luberda
