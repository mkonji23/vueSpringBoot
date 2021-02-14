module.exports = {
    "env": {
        "browser": true,
        "es2020": true,
        "node": true
    },
    "extends": [
        "eslint:recommended",
        "plugin:vue/essential",
        'prettier',
        'plugin:prettier/recommended'
    ],
    "parserOptions": {
        "ecmaVersion": 11,
        "sourceType": "module",
        "parser": "babel-eslint"
    },
    "plugins": [
        "vue",
        'prettier'
    ],
    "rules": {
        'prettier/prettier': [
            'error',
            // 아래 규칙들은 개인 선호에 따라 prettier 문법 적용
            // https://prettier.io/docs/en/options.html
            {
              singleQuote: true,
              semi: true,
              useTabs: true,
              tabWidth: 2,
              trailingComma: 'all',
              printWidth: 80,
              bracketSpacing: true,
              arrowParens: 'avoid',
            },
          ],
          'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
          'no-unused-vars': 'off',
          'vue/no-unused-components': 'off' // 미사용 변수 체크 해제
        },
};
