# FEM_Acoustic_vibrations_of_a_material_layer
Differential and difference equations - project 2022/2023.

<p align="center">
  <a href="" rel="noopener">
    <img width=600px height=200px src="Równanie problemu.png" alt="Project logo">
  </a>
</p>

<h3 align="center"></h3>
— — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — -

<p align=”center”> 
<br>
</p>

## 📝 Table of Contents

- [Calculations](#calculations)
- [About](#about)
- [Getting Started](#getting_started)
- [Built Using](#built_using)
- [Example](#example)
- [Authors](#authors)




## :point_right: Calculations <a name = “calculations”></a>

Mathematical paper with calculations used to obtain matrix form of the problem can be found [in this pdf](Zadanie_Obliczeniowe.pdf).

## 🧐 About <a name = “about”></a>
To równanie opisuje problem związany z wibracjami akustycznymi warstwy materiału. Równanie to jest równaniem różniczkowym cząstkowym drugiego rzędu z warunkami brzegowymi na granicach przedziału [0, 2]. Można go rozwiązać przy użyciu różnych metod numerycznych, takich jak metoda elementów skończonych, która jest implementowana w podanym kodzie.

## 🏁 Getting Started <a name = “getting_started”> </a>
 Działanie kodu:
 Algorytm implementowany w tym kodzie stosuje metodę elementów skończonych do rozwiązywania równań różniczkowych cząstkowych. Klasa IterativeLegendreGaussIntegrator jest używana do wykonywania numerycznego całkowania, a metody base i basePrim definiują bazowe funkcje, które są używane. Metoda coefficients służy do znajdowania współczynników dla tych funkcji poprzez rozwiązywanie układu równań liniowych reprezentowanego przez macierze bMatrix i vectorL. Metoda getBMatrix oblicza elementy macierzy bMatrix, a metoda getLMatrix oblicza elementy macierzy vectorL. Następnie tworzony jest wykres.


## ⛏️ Built Using <a name = “built_using”></a>
Projekt został stworzony w języku programowania Java z użyciem biblioteki JavaFX

## :brain: Example:  <a name = “example”></a>
Przykład dla N = 20:

<p align="center">
  <a href="" rel="noopener">
    <img width=800px height=500px src="Example.png" alt="Project logo">
  </a>
</p>


## ✍️ Authors <a name = “authors”></a>
Natalia Luberda
