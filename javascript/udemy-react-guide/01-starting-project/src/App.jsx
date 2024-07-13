import { useState } from 'react';

import { CORE_CONCEPTS, EXAMPLES } from './data.js';
import Header from './components/Header/Header';
import CoreConcept from './components/CoreConcept';
import TabButton from './components/TabButton';

function App() {
  const [selectedTopic, setSelectedTopic ]= useState();

  function onClickHandler(buttonName) {
    setSelectedTopic(buttonName);
  }

  return (
    <div>
      <Header/>
      <main>
        <section id="core-concepts">
          <h2>Core Concepts</h2>
          <ul>
            {CORE_CONCEPTS.map((conceptItem) => <CoreConcept key={conceptItem.item} {...conceptItem} />)}
          </ul>
        </section>

        <section id="examples">
          <h2>Examples</h2>
          <menu>
            <TabButton isSelected={selectedTopic=="components"} onClickHandler={() => onClickHandler("components")}> Components </TabButton>
            <TabButton isSelected={selectedTopic=="jsx"} onClickHandler={() => onClickHandler("jsx")}>JSX</TabButton>
            <TabButton isSelected={selectedTopic=="props"} onClickHandler={() => onClickHandler("props")}>Props</TabButton>
            <TabButton isSelected={selectedTopic=="state"} onClickHandler={() => onClickHandler("state")}>State</TabButton>
          </menu>
          {!selectedTopic ? (
            <p> Please select a topic</p>
          ) : (
            <div id="tab-content">
              <h3> {EXAMPLES[selectedTopic].title} </h3>
              <p> {EXAMPLES[selectedTopic].description} </p>
              <pre>
                <code>
                  {EXAMPLES[selectedTopic].code}
                </code>
              </pre>
            </div>
          )}
        </section>
      </main>
    </div>
  );
}

export default App;
