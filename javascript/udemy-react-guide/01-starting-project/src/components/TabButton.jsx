export default function TabButton({children, onClickHandler, isSelected}) {
    return (
      <li>
        <button className={isSelected ? "active" : undefined} onClick={onClickHandler}>{children}</button>
      </li>
    );
}