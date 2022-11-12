import {
  Box,
  Button,
  CircularProgress,
  Grid,
  Link,
  TextField,
} from '@mui/material';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import * as yup from 'yup';
import HomemImg from '../../shared/assets/homem_binoculos.png';
import { Copyright } from '../../shared/components/Copyright';
import { useAuthContext } from '../../shared/contexts';
import { LayoutBaseDePaginaInicial } from '../../shared/layouts';

const loginSchema = yup.object().shape({
  email: yup.string().email().required(),
  senha: yup.string().required().min(3),
});

export const SignIn = () => {
  const navigate = useNavigate();
  const { login } = useAuthContext();
  const image = {
    src: HomemImg,
    alt: 'Homem segurando binúculos',
  };

  const [isLoading, setIsLoading] = useState(false);

  const [emailError, setEmailError] = useState('');
  const [senhaError, setSenhaError] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');

  const handleClickNavigate = (to: string) => {
    navigate(to);
  };

  const handleSubmit = () => {
    setIsLoading(true);

    loginSchema
      .validate({ email, senha }, { abortEarly: false })
      .then((dadosValidos) => {
        login(dadosValidos.email, dadosValidos.senha).then(() => {
          setIsLoading(false);
        });
      })
      .catch((errors: yup.ValidationError) => {
        setIsLoading(false);
        errors.inner.forEach((error) => {
          if (error.path === 'email') {
            setEmailError(error.message);
          } else if (error.path === 'senha') {
            setSenhaError(error.message);
          }
        });
      });
  };

  return (
    <LayoutBaseDePaginaInicial titulo='Fazer login' image={image}>
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}
      >
        <Box sx={{ mt: 1 }}>
          <TextField
            margin='normal'
            required
            fullWidth
            id='email'
            label='Email'
            name='email'
            autoComplete='email'
            autoFocus
            value={email}
            disabled={isLoading}
            error={!!emailError}
            helperText={emailError}
            onKeyDown={() => setEmailError('')}
            onChange={(e) => setEmail(e.target.value)}
          />
          <TextField
            margin='normal'
            required
            fullWidth
            name='senha'
            label='Senha'
            type='password'
            id='senha'
            autoComplete='current-password'
            disabled={isLoading}
            value={senha}
            error={!!senhaError}
            helperText={senhaError}
            onKeyDown={() => setSenhaError('')}
            onChange={(e) => setSenha(e.target.value)}
          />
          <Box sx={{ m: 1, position: 'relative' }}>
            <Button
              onClick={handleSubmit}
              disabled={isLoading}
              color='secondary'
              endIcon={
                isLoading ? (
                  <CircularProgress
                    variant='indeterminate'
                    color='inherit'
                    size={20}
                  />
                ) : undefined
              }
              fullWidth
              sx={{ my: 3 }}
              variant='contained'
            >
              Entrar
            </Button>
          </Box>
          <Grid container>
            <Grid item>
              <Link
                onClick={() => handleClickNavigate('/cadastro-usuario')}
                variant='body2'
                sx={{ cursor: 'pointer' }}
              >
                Não tem uma conta? Cadastre-se
              </Link>
            </Grid>
          </Grid>
        </Box>
      </Box>
      <Copyright />
    </LayoutBaseDePaginaInicial>
  );
};
