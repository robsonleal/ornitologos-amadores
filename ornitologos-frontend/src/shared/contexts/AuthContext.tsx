import {
  createContext,
  useCallback,
  useContext,
  useEffect,
  useMemo,
  useState,
} from 'react';
import { Usuario } from '../models';
import { AuthService } from '../services/api/auth/AuthService';

interface IAuthContextData {
  logout: () => void;
  isAuthenticated: boolean;
  login: (email: string, senha: string) => Promise<string | void>;
}

const LOCAL_STORAGE_KEY_ACCESS_TOKEN = 'token';

interface IAuthProviderProps {
  children: React.ReactNode;
}

const AuthContext = createContext({} as IAuthContextData);

export const AuthProvider: React.FC<IAuthProviderProps> = ({ children }) => {
  const [token, setToken] = useState<string>();

  useEffect(() => {
    const token = localStorage.getItem(LOCAL_STORAGE_KEY_ACCESS_TOKEN);

    if (token) {
      setToken(token);
    } else {
      setToken(undefined);
    }
  }, []);

  const handleLogin = useCallback(async (email: string, senha: string) => {
    const usuario: Usuario = { email, senha };
    const result = await AuthService.fazerLogin(usuario);
    if (result instanceof Error) {
      return result.message;
    } else {
      localStorage.setItem(LOCAL_STORAGE_KEY_ACCESS_TOKEN, result.token || '');
      setToken(result.token);
    }
  }, []);

  const handleLogout = useCallback(() => {
    localStorage.removeItem(LOCAL_STORAGE_KEY_ACCESS_TOKEN);
    setToken(undefined);
  }, []);

  const isAuthenticated = useMemo(() => !!token, [token]);

  return (
    <AuthContext.Provider
      value={{ isAuthenticated, login: handleLogin, logout: handleLogout }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuthContext = () => useContext(AuthContext);
