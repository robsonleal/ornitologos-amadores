import { createContext, useCallback, useContext, useState } from 'react';

interface IBarraTopoOption {
  path: string;
  label: string;
}

interface IBarraTopoData {
  barraTopoOptions: IBarraTopoOption[];
  setBarraTopoOption: (newBarraTopoOptions: IBarraTopoOption[]) => void;
}

interface IBarraTopoContextProps {
  children: React.ReactNode;
}

const BarraTopoContext = createContext({} as IBarraTopoData);

export const useBarraTopoContext = () => {
  return useContext(BarraTopoContext);
};

export const BarraTopoProvider: React.FC<IBarraTopoContextProps> = ({
  children,
}) => {
  const [barraTopoOptions, setBarraTopoOptions] = useState<IBarraTopoOption[]>(
    []
  );

  const handleSetBarraTopoOptions = useCallback(
    (newBarraTopoOptions: IBarraTopoOption[]) => {
      setBarraTopoOptions(newBarraTopoOptions);
    },
    []
  );

  return (
    <BarraTopoContext.Provider
      value={{
        barraTopoOptions: barraTopoOptions,
        setBarraTopoOption: handleSetBarraTopoOptions,
      }}
    >
      {children}
    </BarraTopoContext.Provider>
  );
};
