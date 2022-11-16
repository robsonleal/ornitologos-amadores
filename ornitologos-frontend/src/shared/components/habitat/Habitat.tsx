import BCA from '../../assets/habitats/BCA.png';
import BSA from '../../assets/habitats/BSA.png';
import CAA from '../../assets/habitats/CAA.png';
import CAU from '../../assets/habitats/CAU.png';
import CSA from '../../assets/habitats/CSA.png';
import CSB from '../../assets/habitats/CSB.png';

let tHabitat: 'BCA' | 'BSA' | 'CAA' | 'CAU' | 'CSA' | 'CSB';

interface IHabitatProps {
  habitat: typeof tHabitat;
}

export const Habitat: React.FC<IHabitatProps> = ({ habitat }) => {
  const imagens = new Map<string, string>([
    ['BCA', BCA],
    ['BSA', BSA],
    ['CAA', CAA],
    ['CAU', CAU],
    ['CSA', CSA],
    ['CSB', CSB],
  ]);

  return <img src={imagens.get(habitat)} width={70} height={50} />;
};
